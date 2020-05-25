package com.jsite.manager;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.IdentityService;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.core.config.Global;
import com.jsite.core.mapper.JsonMapper;
import com.jsite.core.page.Page;
import com.jsite.core.security.Digests;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceException;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.Encodes;
import com.jsite.core.utils.StringUtils;
import com.jsite.dao.sys.DdsSysUserinfoDao;
import com.jsite.dao.sys.MenuDao;
import com.jsite.dao.sys.RoleDao;
import com.jsite.dao.sys.UserDao;
import com.jsite.dao.sys.po.DdsSysUserinfo;
import com.jsite.dao.sys.po.Menu;
import com.jsite.dao.sys.po.Office;
import com.jsite.dao.sys.po.Role;
import com.jsite.dao.sys.po.User;
import com.jsite.manager.AbstractBaseService;
import com.jsite.manager.cache.CacheUtils;
import com.jsite.manager.ckfinder.Servlets;
import com.jsite.manager.constraints.ValidateUtils;
import com.jsite.manager.constraints.Violation;
import com.jsite.manager.log.LogDaoUtils;
import com.jsite.manager.security.SystemAuthorizingRealm;
import com.jsite.manager.security.shiro.session.SessionDAO;
import com.jsite.manager.user.UserUtils;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 */
@Service
@Transactional(readOnly = true)
public class SystemService extends AbstractBaseService implements InitializingBean {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private DdsSysUserinfoDao ddsSysUserinfoDao;
	/*@Autowired 未加入单点登录，先注释掉
	private SessionDAO sessionDao;*/
	@Autowired
	private SystemAuthorizingRealm systemRealm;
	
	/*public SessionDAO getSessionDao() {
		return sessionDao;
	}*/

	/*@Autowired  未加入单点登录，先注释掉
	private IdentityService identityService;*/

	//-- User Service --//
	
	/**
	 * 获取用户
	 * @param id
	 * @return
	 */
	public DdsSysUserinfo getUser(String id) {
		return UserUtils.get(id);
	}

	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return
	 */
	public DdsSysUserinfo getUserByLoginName(String loginName) {
		return UserUtils.getByLoginName(loginName);
	}
	
	public Page<DdsSysUserinfo> findUser(Page<DdsSysUserinfo> page, DdsSysUserinfo user,HttpServletRequest request) {
		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		user.getSqlMap().put("dsf", dataScopeFilter(UserUtils.getUser(request), "o", "a"));
		// 设置分页参数
		user.setPage(page);
		// 执行分页查询
		page.setList(ddsSysUserinfoDao.list(user));
		return page;
	}
	
	/**
	 * 无分页查询人员列表
	 * @param user
	 * @return
	 */
	public List<DdsSysUserinfo> findUser(HttpServletRequest request,DdsSysUserinfo user){
		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		user.getSqlMap().put("dsf", dataScopeFilter(UserUtils.getUser(request), "o", "a"));
		List<DdsSysUserinfo> list = ddsSysUserinfoDao.list(user);
		return list;
	}

	/**
	 * 通过部门ID获取用户列表，仅返回用户id和name（树查询用户时用）
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUserByOfficeId(String officeId) {
		List<User> list = (List<User>)CacheUtils.get(UserUtils.USER_CACHE, UserUtils.USER_CACHE_LIST_BY_OFFICE_ID_ + officeId);
		if (list == null){
			User user = new User();
			Office office = new Office();
			office.setId(officeId);
			user.setOffice(office);
			list = userDao.listUserDOByOfficeId(user);
			CacheUtils.put(UserUtils.USER_CACHE, UserUtils.USER_CACHE_LIST_BY_OFFICE_ID_ + officeId, list);
		}
		return list;
	}
	
	@Transactional(readOnly = false)
	public void saveUser(DdsSysUserinfo user) {
		if (StringUtils.isBlank(user.getId())){
			user.preInsert();
			ddsSysUserinfoDao.save(user);
		}else{
			// 清除原用户机构用户缓存
			User oldUser = userDao.get(user.getId());
			if (oldUser.getOffice() != null && oldUser.getOffice().getId() != null){
				CacheUtils.remove(UserUtils.USER_CACHE, UserUtils.USER_CACHE_LIST_BY_OFFICE_ID_ + oldUser.getOffice().getId());
			}
			// 更新用户数据
			user.preUpdate();
			ddsSysUserinfoDao.update(user);
		}
		if (StringUtils.isNotBlank(user.getUserCode())){
			// 更新用户与角色关联
			/*ddsSysUserinfoDao.removeUserDORole(user);
			if (user.getRoleDOList() != null && user.getRoleDOList().size() > 0){
				ddsSysUserinfoDao.saveUserDORole(user);
			}else{
				throw new ServiceException(user.getUserName() + "没有设置角色！");
			}*/
			// 清除用户缓存
			UserUtils.clearCache(user);
//			// 清除权限缓存
//			systemRealm.clearAllCachedAuthorizationInfo();
		}
	}
	
	@Transactional(readOnly = false)
	public void updateUserInfo(DdsSysUserinfo user) {
		user.preUpdate();
		//ddsSysUserinfoDao.updateUserDOInfo(user);
		ddsSysUserinfoDao.update(user);
		// 清除用户缓存
		UserUtils.clearCache(user);
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
	}
	
	@Transactional(readOnly = false)
	public void deleteUser(DdsSysUserinfo user) {
		ddsSysUserinfoDao.remove(user);
		// 清除用户缓存
		UserUtils.clearCache(user);
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
	}
	
	//对于集成单点登录功能来说，不可再此系统中修改用户的信息
	@Transactional(readOnly = false)
	public void updatePasswordById(String id, String loginName, String newPassword) {
	/*	DdsSysUserinfo user = new DdsSysUserinfo();
		user.setUserCode(id);
		user.setPasswd(entryptPassword(newPassword));
		ddsSysUserinfoDao.updatePasswordById(user);
		// 清除用户缓存
		user.setLoginName(loginName);
		UserUtils.clearCache(user);*/
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
	}
	
	@Transactional(readOnly = false)
	public void updateUserLoginInfo(User user) {
		// 保存上次登录信息
		user.setOldLoginIp(user.getLoginIp());
		user.setOldLoginDate(user.getLoginDate());
		// 更新本次登录信息
		user.setLoginIp(StringUtils.getRemoteAddr(Servlets.getRequest()));
		user.setLoginDate(new Date());
		userDao.updateLoginInfo(user);
	}
	
	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String plainPassword) {
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}
	
	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Encodes.decodeHex(password.substring(0,16));
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
	}
	
	/**
	 * 获得活动会话
	 * @return
	 */
	/*public Collection<Session> getActiveSessions(){
		return sessionDao.getActiveSessions(false);
	}*/
	
	//-- Role Service --//
	
	public Role getRole(String id) {
		return roleDao.get(id);
	}

	public Role getRoleByName(String name) {
		Role r = new Role();
		r.setName(name);
		return roleDao.getByName(r);
	}
	
	public Role getRoleByEnname(String enname) {
		Role r = new Role();
		r.setEnname(enname);
		return roleDao.getByEnname(r);
	}
	
	public List<Role> findRole(Role role){
		return roleDao.list(role);
	}
	
	public List<Role> findAllRole(HttpServletRequest request){
		return UserUtils.getRoleList(request);
	}
	
	@Transactional(readOnly = false)
	public void saveRole(Role role) {
		if (StringUtils.isBlank(role.getId())){
			role.preInsert();
			roleDao.save(role);
		}else{
			role.preUpdate();
			roleDao.update(role);
		}
		// 更新角色与菜单关联
		roleDao.removeRoleMenu(role);
		if (role.getMenuList().size() > 0){
			roleDao.saveRoleMenu(role);
		}
		// 更新角色与部门关联
		/*roleDao.removeRoleDept(role);
		if (role.getDeptList().size() > 0){
			roleDao.saveRoleDept(role);
		}*/
		// 清除用户角色缓存
//		UserUtils.removeCache(UserUtils.CACHE_ROLE_LIST);
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
	}

	@Transactional(readOnly = false)
	public void deleteRole(Role role) {
		roleDao.remove(role);
		// 清除用户角色缓存
//		UserUtils.removeCache(UserUtils.CACHE_ROLE_LIST);
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
	}
	
	@Transactional(readOnly = false)
	public Boolean outUserInRole(Role role, DdsSysUserinfo user) {
		List<Role> roles = user.getRoleDOList();
		for (Role e : roles){
			if (e.getId().equals(role.getId())){
				roles.remove(e);
				saveUser(user);
				return true;
			}
		}
		return false;
	}
	
	@Transactional(readOnly = false)
	public DdsSysUserinfo assignUserToRole(Role role, DdsSysUserinfo user) {
		if (user == null){
			return null;
		}
		List<String> roleIds = user.getRoleDOIdList();
		if (roleIds.contains(role.getId())) {
			return null;
		}
		user.getRoleDOList().add(role);
		saveUser(user);
		return user;
	}

	//-- Menu Service --//
	
	public Menu getMenu(String id) {
		return menuDao.get(id);
	}

	public List<Menu> findAllMenu(HttpServletRequest request){
		return UserUtils.getMenuList(request);
	}
	
	/**
	 * 根据角色获取菜单信息
	 * @param menu
	 * @return
	 */
	public List<Menu> findByRoleId(Menu menu){
		return menuDao.findByRoleId(menu);
	}
	
	@Transactional(readOnly = false)
	public void saveMenu(Menu menu) {
		
		// 获取父节点实体
		menu.setParent(this.getMenu(menu.getParent().getId()));
		
		// 获取修改前的parentIds，用于更新子节点的parentIds
		Menu entity = new Menu();
		String oldParentIds = menu.getParent().getParentIds();
		// 设置新的父节点串
		menu.setParentIds(menu.getParent().getParentIds()+menu.getParent().getId()+",");

		// 保存或更新实体
		if (StringUtils.isBlank(menu.getId())){
			menu.preInsert();
			menuDao.save(menu);
		}else{
			entity = menuDao.get(menu.getId());
			oldParentIds = entity.getParentIds();
			menu.preUpdate();
			menuDao.update(menu);
		}
		entity.getParentIds(); 
		// 更新子节点 parentIds
		Menu m = new Menu();
		m.setParentIds("%,"+menu.getId()+",%");
		List<Menu> list = menuDao.findByParentIdsLike(m);
		for (Menu e : list){
			e.setParentIds(e.getParentIds().replace(oldParentIds, menu.getParentIds()));
			menuDao.updateParentIds(e);
		}
		// 清除用户菜单缓存
		UserUtils.removeCache(UserUtils.CACHE_MENU_LIST);
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
		// 清除日志相关缓存
		CacheUtils.remove(LogDaoUtils.CACHE_MENU_NAME_PATH_MAP);
	}

	/**
	 * 修改数据（更新）
	 * 
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public ServiceResp update(Menu menu) {
		ServiceResp serviceResp = new ServiceResp();
		List<Violation> violations = ValidateUtils.validate(menu);
		if (violations.size() > 0) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_2);
			serviceResp.setMsg(JsonMapper.toJsonString(violations));
		} else {
			try {
				menuDao.update(menu);
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
			} catch (Exception e) {
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
			}
		}
		return serviceResp;
	}
	
	@Transactional(readOnly = false)
	public void updateMenuSort(Menu menu) {
		menuDao.updateSort(menu);
		// 清除用户菜单缓存
		UserUtils.removeCache(UserUtils.CACHE_MENU_LIST);
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
		// 清除日志相关缓存
		CacheUtils.remove(LogDaoUtils.CACHE_MENU_NAME_PATH_MAP);
	}

	@Transactional(readOnly = false)
	public void deleteMenu(Menu menu) {
		menuDao.remove(menu);
		// 清除用户菜单缓存
		UserUtils.removeCache(UserUtils.CACHE_MENU_LIST);
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
		// 清除日志相关缓存
		CacheUtils.remove(LogDaoUtils.CACHE_MENU_NAME_PATH_MAP);
	}
	
	/**
	 * 获取Key加载信息
	 */
	public static boolean printKeyLoadMessage(){
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n======================================================================\r\n");
		sb.append("\r\n    欢迎使用 "+Global.getConfig("productName"));
		sb.append("\r\n======================================================================\r\n");
		System.out.println(sb.toString());
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	 
}
