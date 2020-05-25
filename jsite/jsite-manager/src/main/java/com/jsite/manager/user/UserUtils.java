package com.jsite.manager.user;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.jasig.cas.client.util.AssertionHolder;
import org.jsite.si.CasUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.spring.SpringContextHolder;
import com.jsite.dao.sys.AreaDao;
import com.jsite.dao.sys.DdsSysUserinfoDao;
import com.jsite.dao.sys.MenuDao;
import com.jsite.dao.sys.OfficeDao;
import com.jsite.dao.sys.RoleDao;
import com.jsite.dao.sys.UserDao;
import com.jsite.dao.sys.po.Area;
import com.jsite.dao.sys.po.DdsSysUserinfo;
import com.jsite.dao.sys.po.Menu;
import com.jsite.dao.sys.po.Office;
import com.jsite.dao.sys.po.Role;
import com.jsite.dao.sys.po.User;
import com.jsite.manager.AbstractBaseService;
import com.jsite.manager.cache.CacheUtils;
import com.jsite.manager.security.SystemAuthorizingRealm.Principal;

import cn.com.dhcc.uums.service.uums.UserInfo;

/**
 * 用户工具类
 */
public class UserUtils {
	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	private static RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);
	private static MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);
	private static AreaDao areaDao = SpringContextHolder.getBean(AreaDao.class);
	private static OfficeDao officeDao = SpringContextHolder.getBean(OfficeDao.class);
	
	private static DdsSysUserinfoDao ddsSysUserinfoDao = SpringContextHolder.getBean(DdsSysUserinfoDao.class);

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";
	
	public static final String CACHE_AUTH_INFO = "authInfo";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static DdsSysUserinfo get(String userCode){
		//DdsSysUserinfo user = (DdsSysUserinfo)CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
		UserInfo ui = CasUtils.getCurrentUser();
		//if (user ==  null){
			//DdsSysUserinfo user = ddsSysUserinfoDao.get(userCode);
		if (ui == null){
			return null;
		}
		DdsSysUserinfo user = new DdsSysUserinfo();
		user.setUserCode(ui.getUserCode());
		user.setUserName(ui.getUserName());
		user.setDepCode(ui.getOrgCode());
		user.setDepName(ui.getOrgName());
		Role role = new Role();
		role.setUserDO(user);
		List<Role> roleList = roleDao.list(role);
		user.setRoleDOList(roleList);
		putCache(USER_CACHE, user);
			//CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			//CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getUserName(), user);
		//}
		return user;
	}
	
	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static DdsSysUserinfo getByLoginName(String loginName){
		DdsSysUserinfo user = (DdsSysUserinfo)CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
		if (user == null){
			user = new DdsSysUserinfo();
//			user.setLoginName(loginName);
			user = ddsSysUserinfoDao.get(user);
			if (user == null){
				return null;
			}
			Role role = new Role();
			role.setUserDO(user);
			List<Role> roleList = roleDao.list(role);
			user.setRoleDOList(roleList);
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getUserName(), user);
		}
		return user;
	}
	
	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache(HttpServletRequest request){
		removeCache(CACHE_AUTH_INFO);
		removeCache(CACHE_ROLE_LIST);
		removeCache(CACHE_MENU_LIST);
		removeCache(CACHE_AREA_LIST);
		removeCache(CACHE_OFFICE_LIST);
		removeCache(CACHE_OFFICE_ALL_LIST);
		UserUtils.clearCache(getUser(request));
	}
	
	/**
	 * 清除指定用户缓存
	 * @param user
	 */
	public static void clearCache(DdsSysUserinfo user){
		CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getUserName());
		//CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getOldLoginName());
		if (user.getDepCode()!= null ){
			CacheUtils.remove(USER_CACHE, USER_CACHE_LIST_BY_OFFICE_ID_ + user.getDepCode());
		}
	}
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static DdsSysUserinfo getUser(HttpServletRequest request){
	//	Principal principal = getPrincipal();
		/*
		if (principal!=null){
			User user = get(principal.getId());
			if (user != null){
				return user;
			}
			return new User();
		}*/
//		UserInfo user = SsoUtil.getUserInfo(request);
		DdsSysUserinfo user = new DdsSysUserinfo();
		user.setUserCode("361001198311014211");
		user.setUserName("章");
//		String user = AssertionHolder.getAssertion().getPrincipal().getName();
//		if(StringUtils.isNotBlank(user)){
//			DdsSysUserinfo userInfo = get(user);
//			if (userInfo != null){
//				return userInfo;
//			}
//			return new DdsSysUserinfo();
//		}
		// 如果没有登录，则返回实例化空的User对象。
		return new DdsSysUserinfo();
	}

	/**
	 * 获取当前用户角色列表
	 * @return
	 */
	public static List<Role> getRoleList(HttpServletRequest request){
		//未加入单点登录，手动注入
		List<Role> roleList = null;//(List<Role>)getCache(CACHE_ROLE_LIST);
		if (roleList == null){
			DdsSysUserinfo user = getUser(request);
			if (user.isAdmin()){
				roleList = roleDao.list(new Role());
			}else{
				Role role = new Role();
				//role.getSqlMap().put("dsf", AbstractBaseService.dataScopeFilter(getUser(request), "o", "u"));
				roleList = roleDao.list(role);
			}
			//putCache(CACHE_ROLE_LIST, roleList);
		}
		return roleList;
	}
	
	/**
	 * 获取当前用户授权菜单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Menu> getMenuList(HttpServletRequest request){
		//未加入单点登录验证，每次都自动获取
		//List<Menu> menuList = (List<Menu>)getCache(CACHE_MENU_LIST);
		List<Menu> menuList = null ;
		if (menuList == null){
			DdsSysUserinfo user = getUser(request);
			//if (user.isAdmin()){
			//	menuList = menuDao.findAllList(new Menu());
			//}else{
				Menu m = new Menu();
				//m.setUserId(user.getUserCode());
				m.setUserId("361001198311014211");
				m.setDelFlag("0");
				m.setIsShow("1");
				menuList = menuDao.findByUserId(m);
			//}
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}
	
	/**
	 * 获取当前用户授权的区域
	 * @return
	 */
	public static List<Area> getAreaList(){
		@SuppressWarnings("unchecked")
		List<Area> areaList = (List<Area>)getCache(CACHE_AREA_LIST);
		if (areaList == null){
			areaList = areaDao.list(new Area());
			putCache(CACHE_AREA_LIST, areaList);
		}
		return areaList;
	}
	
	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	public static List<Office> getOfficeList(HttpServletRequest request){
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_LIST);
		if (officeList == null){
			DdsSysUserinfo user = getUser(request);
			if (user.isAdmin()){
				officeList = officeDao.list(new Office());
			}else{
				Office officeDo = new Office();
				//officeDo.getSqlMap().put("dsf", AbstractBaseService.dataScopeFilter(user, "a", ""));
				officeList = officeDao.list(officeDo);
			}
			putCache(CACHE_OFFICE_LIST, officeList);
		}
		return officeList;
	}

	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	public static List<Office> getOfficeAllList(){
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_ALL_LIST);
		if (officeList == null){
			officeList = officeDao.list(new Office());
		}
		return officeList;
	}
	
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
//			subject.logout();
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	public static HttpSession getSession(){
		try{
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = requestAttributes.getRequest();
			HttpSession httpSession = request.getSession(false);
			//Subject subject = SecurityUtils.getSubject();
			//Session session = subject.getSession(false);
			if (httpSession == null){
				httpSession = request.getSession();
			}
			if (httpSession != null){
				return httpSession;
			}
//			subject.logout();
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	// ============== User Cache ==============
	
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
//		Object obj = getCacheMap().get(key);
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
//		getCacheMap().put(key, value);
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
//		getCacheMap().remove(key);
		getSession().removeAttribute(key);
	}
	
//	public static Map<String, Object> getCacheMap(){
//		Principal principal = getPrincipal();
//		if(principal!=null){
//			return principal.getCacheMap();
//		}
//		return new HashMap<String, Object>();
//	}
	
}
