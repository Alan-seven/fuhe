package com.jsite.szy.dispatch.sys.web;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jsite.busi.szy.sys.service.UserInfoService;
import com.jsite.core.config.Global;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.Collections3;
import com.jsite.core.web.BaseController;
import com.jsite.dao.sys.po.DdsSysUserinfo;
import com.jsite.dao.sys.po.Role;
import com.jsite.dao.sys.po.User;
import com.jsite.manager.SystemService;
import com.jsite.manager.user.UserUtils;
import com.jsite.szy.dispatch.sys.vo.RoleVO;

import cn.com.dhcc.uums.service.uums.RoleInfo;
import cn.com.dhcc.uums.service.uums.UumsServiceImplService;
import cn.com.dhcc.uums.service.uums.UumsServiceImplServiceLocator;
import cn.com.dhcc.uums.service.uums.UumsServiceImplServiceSoapBindingStub;

@Controller
@RequestMapping(value = "${adminPath}/szy/sys/role")
public class RoleController extends BaseController{

	@Autowired
	private SystemService systemService;
	
	@Autowired
	private UserInfoService ddsSysUserinfoService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id,HttpServletResponse response) {
		Map<String,Object> map = Maps.newHashMap();
		RoleVO roleVO = new RoleVO();
		if (StringUtils.isNotBlank(id)){
			Role role =  systemService.getRole(id);
			map.put("role", role);
			if(null!=role){
				roleVO = BeanMapper.map(role, roleVO.getClass());
			}
		}
		return renderString(response, roleVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(RoleVO roleVO, HttpServletResponse response) {
		Role role = new Role();
		if(null!=roleVO){
			role = BeanMapper.map(roleVO, role.getClass());
		}
		List<Role> list = systemService.findRole(role);
		return renderString(response,list);
	}
	
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(RoleVO roleVO, HttpServletRequest request,HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		/*if(!UserUtils.getUser().isAdmin()&&roleVO.getSysData().equals(Global.YES)){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("越权操作，只有超级管理员才能修改此数据！");
			return renderString(response, serviceResp);
		}*/
		if(Global.isDemoMode()){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("演示模式，不允许操作！");
			return renderString(response, serviceResp);
		}
		if (!"true".equals(checkName(roleVO.getOldName(), roleVO.getName()))){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("保存角色'" + roleVO.getName() + "'失败, 角色名已存在");
			return renderString(response, serviceResp);
		}
		/*if (!"true".equals(checkEnname(roleVO.getOldEnname(), roleVO.getEnname()))){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("保存角色'" + roleVO.getName() + "'失败, 英文名已存在");
			return renderString(response, serviceResp);
		}*/
		Role role = new Role();
		if(null!=roleVO){
			role = BeanMapper.map(roleVO, role.getClass());
		}
		systemService.saveRole(role);
		//同步角色致统一用户权限管理系统
		try {
			UumsServiceImplService uumsService =  new UumsServiceImplServiceLocator();
			UumsServiceImplServiceSoapBindingStub binding = (UumsServiceImplServiceSoapBindingStub)uumsService.getUumsServiceImplPort();
			RoleInfo[] roleInfo = new RoleInfo[1];
			RoleInfo rInfo = new RoleInfo();
			rInfo.setRoleCode(role.getId());
			Role entity = systemService.getRole(role.getId());
			rInfo.setRoleName(entity.getName());
			DdsSysUserinfo ddsSysUserinfo = UserUtils.getUser(request);
			String river = request.getParameter("river");
			String sCode = "dispat02";
			if("02".equals(river)){
				sCode = "dispat02";
			}
			if("03".equals(river)){
				sCode = "dispat03";
			}
			rInfo.setScode(sCode);
			rInfo.setRoleType(entity.getRoleType()==null?"05":entity.getRoleType());
			rInfo.setModifier(ddsSysUserinfo.getUserCode());
			RoleInfo syncri = binding.getRoleInfo(role.getId(), sCode);
			
			if(syncri!=null){
				roleInfo[0] = rInfo;
				int code = binding.updateRoleInfo(roleInfo);
				System.out.println("角色更新推送成功个数："+code);
			}else{
				roleInfo[0] = rInfo;
				int code = binding.pushRoleInfo(roleInfo);
				System.out.println("角色推送成功个数："+code);
			}
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
		serviceResp.setMsg("保存角色'" + roleVO.getName() + "'成功");
		return renderString(response, serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(Role role, RedirectAttributes redirectAttributes,HttpServletRequest request,HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		/**if(!UserUtils.getUser(request).isAdmin() && role.getSysData().equals(Global.YES)){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("越权操作，只有超级管理员才能修改此数据！");
			//addMessage(redirectAttributes, "越权操作，只有超级管理员才能修改此数据！");
			//return "redirect:" + adminPath + "/sys/role/?repage";
			return renderString(response, serviceResp);
		}
		if(Global.isDemoMode()){
			//addMessage(redirectAttributes, "演示模式，不允许操作！");
			//return "redirect:" + adminPath + "/sys/role/?repage";
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("演示模式，不允许操作！");
			return renderString(response, serviceResp);
		}*/
//		if (Role.isAdmin(id)){
//			addMessage(redirectAttributes, "删除角色失败, 不允许内置角色或编号空");
////		}else if (UserUtils.getUser().getRoleIdList().contains(id)){
////			addMessage(redirectAttributes, "删除角色失败, 不能删除当前用户所在角色");
//		}else{
			systemService.deleteRole(role);
			try {
				UumsServiceImplService uumsService =  new UumsServiceImplServiceLocator();
				UumsServiceImplServiceSoapBindingStub binding = (UumsServiceImplServiceSoapBindingStub)uumsService.getUumsServiceImplPort();
				RoleInfo[] roleInfo = new RoleInfo[1];
				RoleInfo rInfo = new RoleInfo();
				rInfo.setRoleCode(role.getId());
				DdsSysUserinfo ddsSysUserinfo = UserUtils.getUser(request);
				String river = request.getParameter("river");
				String sCode = "dispat02";
				if("02".equals(river)){
					sCode = "dispat02";
				}
				if("03".equals(river)){
					sCode = "dispat03";
				}
				rInfo.setScode(sCode);
				rInfo.setModifier(ddsSysUserinfo.getUserCode());
				RoleInfo syncri = binding.getRoleInfo(role.getId(), sCode);
				
				if(syncri!=null){
					roleInfo[0] = rInfo;
					int code = binding.deleteRoleInfo(roleInfo);
					System.out.println("删除角色推送成功个数："+code);
				}				
			} catch (AxisFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			addMessage(redirectAttributes, "删除角色成功");
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg("删除角色成功！");
			
//		}
			return renderString(response, serviceResp);
	}
	
	/**
	 * 角色分配页面
	 * @param role
	 * @param model
	 * @return
	 */
//	@RequiresPermissions("sys:role:edit")
//	@RequestMapping(value = "assign")
//	public String assign(Role role, HttpServletRequest request,HttpServletResponse response) {
//		List<Ddssys> userList = systemService.findUser(new User(new Role(role.getId())));
//		return renderString(response, userList);
//	}
	
	/**
	 * 角色分配 -- 打开角色分配对话框
	 * @param role
	 * @param model
	 * @return
	 */
//	@RequiresPermissions("sys:role:view")
//	@RequestMapping(value = "usertorole")
//	public String selectUserToRole(RoleVO roleVO, HttpServletResponse response) {
//		List<User> userList = systemService.findUser(new User(new Role(roleVO.getId())));
//		Map map = new HashMap();
//		map.put("roleVO", roleVO);
//		map.put("userList", userList);
//		map.put("selectIds", Collections3.extractToString(userList, "name", ","));
//		//model.addAttribute("officeList", officeService.findAll());
//		return renderString(response, map);
//	}
	
	/**
	 * 角色分配 -- 根据部门编号获取用户列表
	 * @param officeId
	 * @param response
	 * @return
	 */
	@RequiresPermissions("sys:role:view")
	@ResponseBody
	@RequestMapping(value = "users")
	public String users(String officeId, HttpServletRequest request,HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		DdsSysUserinfo user = new DdsSysUserinfo();
		//user.setOffice(new Office(officeId));
		Page<DdsSysUserinfo> page = systemService.findUser(new Page<DdsSysUserinfo>(1, -1), user,request);
		for (DdsSysUserinfo e : page.getList()) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("pId", 0);
			map.put("name", e.getUserName());
			mapList.add(map);			
		}
		return renderString(response, mapList);
	}
	
	/**
	 * 角色分配 -- 从角色中移除用户
	 * @param userId
	 * @param roleId
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sys:role:edit")
	@RequestMapping(value = "outrole")
	public String outrole(String userId, String roleId, RedirectAttributes redirectAttributes,HttpServletRequest request,HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		if(Global.isDemoMode()){
			/*addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/role/assign?id="+roleId;*/
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("演示模式，不允许操作！");
			return renderString(response, serviceResp);
		}
		Role role = systemService.getRole(roleId);
		DdsSysUserinfo user = systemService.getUser(userId);
		serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
		if (UserUtils.getUser(request).getId().equals(userId)) {
			//addMessage(redirectAttributes, "无法从角色【" + role.getName() + "】中移除用户【" + user.getName() + "】自己！");
			serviceResp.setMsg("无法从角色【" + role.getName() + "】中移除用户【" + user.getUserName() + "】自己！");
		}else {
			if (user.getRoleDOList().size() <= 1){
				//addMessage(redirectAttributes, "用户【" + user.getName() + "】从角色【" + role.getName() + "】中移除失败！这已经是该用户的唯一角色，不能移除。");
				serviceResp.setMsg("用户【" + user.getUserName() + "】从角色【" + role.getName() + "】中移除失败！这已经是该用户的唯一角色，不能移除。");
			}else{
				Boolean flag = systemService.outUserInRole(role, user);
				if (!flag) {
					//addMessage(redirectAttributes, "用户【" + user.getName() + "】从角色【" + role.getName() + "】中移除失败！");
					serviceResp.setMsg("用户【" + user.getUserName() + "】从角色【" + role.getName() + "】中移除失败！");
				}else {
					//addMessage(redirectAttributes, "用户【" + user.getName() + "】从角色【" + role.getName() + "】中移除成功！");
					serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
					serviceResp.setMsg( "用户【" + user.getUserName() + "】从角色【" + role.getName() + "】中移除成功！");
				}
			}		
		}
		return renderString(response, serviceResp);
	}
	
	/**
	 * 角色分配
	 * @param role
	 * @param idsArr
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sys:role:edit")
	@RequestMapping(value = "assignrole")
	public String assignRole(Role role, String[] idsArr, RedirectAttributes redirectAttributes,HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		if(Global.isDemoMode()){
			/*addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/role/assign?id="+role.getId();*/
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("演示模式，不允许操作！");
			return renderString(response, serviceResp);
		}
		StringBuilder msg = new StringBuilder();
		int newNum = 0;
		for (int i = 0; i < idsArr.length; i++) {
			DdsSysUserinfo user = systemService.assignUserToRole(role, systemService.getUser(idsArr[i]));
			if (null != user) {
				msg.append("<br/>新增用户【" + user.getUserName() + "】到角色【" + role.getName() + "】！");
				newNum++;
			}
		}
		//addMessage(redirectAttributes, "已成功分配 "+newNum+" 个用户"+msg);
		serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
		serviceResp.setMsg( "已成功分配 "+newNum+" 个用户"+msg);
		return renderString(response, serviceResp);
	}

	/**
	 * 验证角色名是否有效
	 * @param oldNamef
	 * @param name
	 * @return
	 */
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "checkName")
	public String checkName(String oldName, String name) {
		if (name!=null && name.equals(oldName)) {
			return "true";
		} else if (name!=null && systemService.getRoleByName(name) == null) {
			return "true";
		}
		return "false";
	}

	/**
	 * 验证角色英文名是否有效
	 * @param oldName
	 * @param name
	 * @return
	 */
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "checkEnname")
	public String checkEnname(String oldEnname, String enname) {
		if (enname!=null && enname.equals(oldEnname)) {
			return "true";
		} else if (enname!=null && systemService.getRoleByEnname(enname) == null) {
			return "true";
		}
		return "false";
	}
	
	
}