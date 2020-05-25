package com.jsite.szy.dispatch.sys.web;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.client.util.AssertionHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jsite.core.config.Global;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.IdGen;
import com.jsite.core.web.BaseController;
import com.jsite.dao.sys.po.DeptInfo;
import com.jsite.dao.sys.po.Menu;
import com.jsite.manager.SystemService;
import com.jsite.manager.utils.UserUtils;
import com.jsite.szy.dispatch.sys.bo.MenuTree;
import com.jsite.szy.dispatch.sys.vo.MenuVO;

import cn.com.dhcc.uums.service.uums.DepInfo;
import cn.com.dhcc.uums.service.uums.RelUserRole;
import cn.com.dhcc.uums.service.uums.RoleInfo;
import cn.com.dhcc.uums.service.uums.UumsServiceImplService;
import cn.com.dhcc.uums.service.uums.UumsServiceImplServiceLocator;
import cn.com.dhcc.uums.service.uums.UumsServiceImplServiceSoapBindingStub;

@Controller
@RequestMapping(value = "${adminPath}/szy/sys/menu1")
public class MenuController1 extends BaseController{

	@Autowired
	private SystemService systemService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id,HttpServletResponse response) {
		MenuVO menuVO = new MenuVO();
		if (StringUtils.isNotBlank(id)){
			Menu menu = systemService.getMenu(id);
			if (null != menu) {
				menuVO = BeanMapper.map(menu, menuVO.getClass());
			}
		}
		return renderString(response, menuVO);
	}

	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(HttpServletRequest request,HttpServletResponse response) {
		List<Menu> list = Lists.newArrayList();
		List<Menu> sourcelist = systemService.findAllMenu(request);
		Menu.sortList(list, sourcelist, Menu.getRootId(), true);
        return renderString(response,list);
	}

	@RequestMapping(value = "form")
	public String form(MenuVO menuVO, HttpServletRequest request,HttpServletResponse response) {
		if (menuVO.getParent()==null||menuVO.getParent().getId()==null){
			menuVO.setParent(new MenuVO(menuVO.getRootId()));
		}
		Menu menu = new Menu();
		menu.setParent(systemService.getMenu(menuVO.getParent().getId()));
		// 获取排序号，最末节点排序号+30
		if (StringUtils.isBlank(menu.getId())){
			List<Menu> list = Lists.newArrayList();
			List<Menu> sourcelist = systemService.findAllMenu(request);
			
			Menu.sortList(list, sourcelist, menu.getParentId(), false);
			if (list.size() > 0){
				menu.setSort(list.get(list.size()-1).getSort() + 30);
			}
		}
		return renderString(response,menu);
	}
	
	@ResponseBody
	@RequestMapping(value = { "save", "" })
	public String save(MenuVO menuVO, HttpServletResponse response ) {
		ServiceResp serviceResp = new ServiceResp();
//		if(!UserUtils.getUser().isAdmin()){
//			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
//			serviceResp.setMsg("越权操作，只有超级管理员才能添加或修改数据！");
//			return renderString(response,serviceResp);
//		}
		if(Global.isDemoMode()){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("演示模式，不允许操作！");
			return renderString(response,serviceResp);
		}
		Menu menu = new Menu();
		if(null!=menuVO){
			menu = BeanMapper.map(menuVO, menu.getClass());
		}
		menu.setDelFlag(Global.NO);
		systemService.saveMenu(menu);
		serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
		serviceResp.setMsg("保存成功");
		//addMessage(redirectAttributes, "保存菜单'" + menu.getName() + "'成功");
		return renderString(response, serviceResp);
	}
	
	@RequestMapping(value = "update")
	public String update(MenuVO menuVO, HttpServletResponse response ) {
		ServiceResp serviceResp = new ServiceResp();
		/*if(!UserUtils.getUser().isAdmin()){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("越权操作，只有超级管理员才能添加或修改数据！");
			return renderString(response,serviceResp);
		}*/
		if(Global.isDemoMode()){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("演示模式，不允许操作！");
			return renderString(response,serviceResp);
		}
		Menu menu = new Menu();
		if(null!=menuVO){
			menu = BeanMapper.map(menuVO, menu.getClass());
		}
		systemService.saveMenu(menu);
		serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
		serviceResp.setMsg("保存成功");
		return renderString(response, serviceResp);
	}
	
	@RequestMapping(value = "delete")
	public String delete(Menu menu,HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		if(Global.isDemoMode()){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("演示模式，不允许操作！");
			return renderString(response,serviceResp);
			//addMessage(redirectAttributes, "演示模式，不允许操作！");
			//return "redirect:" + adminPath + "/sys/menu/";
		}
//		if (Menu.isRoot(id)){
//			addMessage(redirectAttributes, "删除菜单失败, 不允许删除顶级菜单或编号为空");
//		}else{
			systemService.deleteMenu(menu);
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg("删除菜单成功！");
			
			//addMessage(redirectAttributes, "删除菜单成功");
//		}
		return renderString(response,serviceResp);
		//return "redirect:" + adminPath + "/sys/menu/";
	}

	//@RequiresPermissions("user")
	@RequestMapping(value = "tree")
	public String tree() {
		return "modules/sys/menuTree";
	}

	//@RequiresPermissions("user")
	/*@RequestMapping(value = "treeselect")
	public String treeselect(String parentId, Model model) {
		model.addAttribute("parentId", parentId);
		return "modules/sys/menuTreeselect";
	}*/
	
	/**
	 * 批量修改菜单排序
	 *//*
	@RequestMapping(value = "updateSort")
	public String updateSort(String[] ids, Integer[] sorts, HttpServletResponse response,RedirectAttributes redirectAttributes) {
		ServiceResp serviceResp = new ServiceResp();
		if(Global.isDemoMode()){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("演示模式，不允许操作！");
			return renderString(response, serviceResp);
			//addMessage(redirectAttributes, "演示模式，不允许操作！");
			//return "redirect:" + adminPath + "/sys/menu/";
		}
    	for (int i = 0; i < ids.length; i++) {
    		Menu menu = new Menu(ids[i]);
    		menu.setSort(sorts[i]);
    		systemService.updateMenuSort(menu);
    	}
    	//addMessage(redirectAttributes, "保存菜单排序成功!");
		//return "redirect:" + adminPath + "/sys/menu/";
    	serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
		serviceResp.setMsg("演保存菜单排序成功！");
		return renderString(response, serviceResp);
	}
	
	/**
	 * isShowHide是否显示隐藏菜单 系统加载菜单
	 * @param extId
	 * @param isShowHidden
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "treeData")
	//public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId,@RequestParam(required=false) String isShowHide, HttpServletResponse response) {
	public String treeData(@RequestParam(required=false) String extId,@RequestParam(required=false) String isShowHide,HttpServletRequest request, HttpServletResponse response) {
		//改为从统一用户中获取角色信息，查询本系统角色与菜单直接的关系
		List<Menu> rootMenu = Lists.newArrayList();//systemService.findAllMenu(request);
		try {
			UumsServiceImplService uumsService =  new UumsServiceImplServiceLocator();
			UumsServiceImplServiceSoapBindingStub binding = (UumsServiceImplServiceSoapBindingStub)uumsService.getUumsServiceImplPort();
			String river = request.getParameter("river");
			String sCode = "dispat02";
			if("02".equals(river)){
				sCode = "dispat02";
			}
			if("03".equals(river)){
				sCode = "dispat03";
			}
			String user = AssertionHolder.getAssertion().getPrincipal().getName();
			//RoleInfo[] roleInfo =  binding.getRoleInfoListByScode(sCode);
			RelUserRole[] roleInfo =  binding.getUserRoleByUserSys(user,sCode);
			//判断部门信息是否为空
			Menu menu = new Menu();
			if(null!=roleInfo){
				
				List<String> roleIds = Lists.newArrayList();
				for(int i = 0 ;i < roleInfo.length ; i++){
					//0未删除
					if(sCode.equals(roleInfo[i].getScode())){
						roleIds.add( roleInfo[i].getRoleCode());
					}
				}
				menu.setDelFlag("0");
				menu.setIsShow("1");
				String[] rid = new String[roleIds.size()];
				for(int j = 0 ; j < roleIds.size() ;j++){
					rid[j] = roleIds.get(j);
				}
				if(rid.length > 0){
					menu.setRoleId(rid);
					rootMenu = systemService.findByRoleId(menu);
					System.out.println("--菜单数据："+rootMenu.size());
				}
				
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
		List<MenuTree> children = Lists.newArrayList();
		extId = "1";
		// 先找到所有的一级菜单
	    for (int i = 0; i < rootMenu.size(); i++) {
	        // 一级菜单
	        if (extId.equals(rootMenu.get(i).getParentId())) {
	        	Menu menu = rootMenu.get(i);
	            MenuTree mt = new MenuTree();
	          	mt.setId(menu.getId());
	          	mt.setLeaf(menu.getLeaf().equals("0")?false:true);
	          	mt.setText(menu.getName());
	          	mt.setIconCls(menu.getIcon());
	          	mt.setViewType(menu.getHref());
	          	mt.setParentId(menu.getParentId());
	        	mt.setIsShow(menu.getIsShow());
	        	mt.setSort( menu.getSort());
	        	children.add(mt);
	        }
	    }
	    
	    for(MenuTree menut : children){
	    	 menut.setChildren(getChild(menut.getId(), rootMenu));
	    }
		
		
		/*List<Menu> list = Lists.newArrayList();
		//设置maplist 根节点
		for(int i = 0 ;i < sourceList.size() ;i++){
			Menu menu = sourceList.get(i);
			if(menu.getId().equals(extId)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", menu.getId());
				map.put("leaf", menu.getLeaf().equals("0")?false:true);
				map.put("text", menu.getName());
				map.put("iconCls", menu.getIcon());
				map.put("viewType", menu.getHref());
				map.put("parentId", menu.getParentId());
				map.put("isShow", menu.getIsShow());
				map.put("sort", menu.getSort());
				String parentName = "";
				Menu entity = systemService.getMenu(menu.getParentId());
				if(null!=entity){
					parentName = entity.getName();
				}
				map.put("parentName",parentName);
				mapList.add(map);
				break;
			}
		}
		//根据根节点获取子节点
		list = getChildMenu(sourceList,extId);
		getJsonData(mapList,sourceList,list);
		List<Map<String, Object>> children = Lists.newArrayList();
		for(int i = 0 ;i < mapList.size() ;i++){
			Map<String, Object> mp = mapList.get(i);
			children = (List<Map<String, Object>>) mp.get("children");
			mapList.clear();
		}*/
		return renderString(response, children);
		//return mapList;
	}
	
	private List<MenuTree> getChild(String id, List<Menu> rootMenu) {
	    // 子菜单
	    List<MenuTree> childList = Lists.newArrayList();
	    for (Menu menu : rootMenu) {
	        // 遍历所有节点，将父菜单id与传过来的id比较
	        if (StringUtils.isNotBlank(menu.getParentId())) {
	            if (menu.getParentId().equals(id)) {
		            MenuTree mt = new MenuTree();
		          	mt.setId(menu.getId());
		          	mt.setLeaf(menu.getLeaf().equals("0")?false:true);
		          	mt.setText(menu.getName());
		          	mt.setIconCls(menu.getIcon());
		          	mt.setViewType(menu.getHref());
		          	mt.setParentId(menu.getParentId());
		        	mt.setIsShow(menu.getIsShow());
		        	mt.setSort( menu.getSort());
		        	childList.add(mt);
	            }
	        }
	    }
	    // 把子菜单的子菜单再循环一遍
	    for (MenuTree mt : childList) {// true 代表叶子节点 
	        if (!mt.getLeaf()) {
	            // 递归
	            mt.setChildren(getChild(mt.getId(), rootMenu));
	        }
	    } // 递归退出条件
	    if (childList.size() == 0) {
	        return null;
	    }
	    return childList;
	}
	
	/*@RequestMapping(value = {"listTree", ""})
	public String listTree(HttpServletRequest request, HttpServletResponse response) {
		List<Menu> list = Lists.newArrayList();
		List<Menu> sourceList = systemService.findAllMenu(request);
		//Menu.sortList(list, sourceList, Menu.getRootId(), true);
		List<Map<String, Object>> mapList = Lists.newArrayList();
		list = getChildMenu(sourceList,"0");
		getJsonData(mapList,sourceList,list);
        return renderString(response,mapList);
	}*/
	
	//根据权限重构  菜单管理功能
 	@RequestMapping(value = {"listTree", ""})
	public String listTree(HttpServletRequest request, HttpServletResponse response) {
 		//List<Menu> rootMenu = systemService.findAllMenu(request);
 		//改为从统一用户中获取角色信息，查询本系统角色与菜单直接的关系
		List<Menu> rootMenu = Lists.newArrayList();//systemService.findAllMenu(request);
		try {
			UumsServiceImplService uumsService =  new UumsServiceImplServiceLocator();
			UumsServiceImplServiceSoapBindingStub binding = (UumsServiceImplServiceSoapBindingStub)uumsService.getUumsServiceImplPort();
			String river = request.getParameter("river");
			String sCode = "dispat02";
			if("02".equals(river)){
				sCode = "dispat02";
			}
			if("03".equals(river)){
				sCode = "dispat03";
			}
			String user = AssertionHolder.getAssertion().getPrincipal().getName();
			//RoleInfo[] roleInfo =  binding.getRoleInfoListByScode(sCode);
			RelUserRole[] roleInfo =  binding.getUserRoleByUserSys(user,sCode);
			//判断部门信息是否为空
			Menu menu = new Menu();
			if(null!=roleInfo){
				List<String> roleIds = Lists.newArrayList();
				for(int i = 0 ;i < roleInfo.length ; i++){
					//0未删除
					if(sCode.equals(roleInfo[i].getScode())){
						roleIds.add( roleInfo[i].getRoleCode());
					}
				}
				menu.setDelFlag("0");
				menu.setIsShow("1");
				String[] rid = new String[roleIds.size()];
				for(int j = 0 ; j < roleIds.size() ;j++){
					rid[j] = roleIds.get(j);
				}
				if(rid.length > 0){
					menu.setRoleId(rid);
					rootMenu = systemService.findByRoleId(menu);
					System.out.println("--菜单数据："+rootMenu.size());
				}				
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
		List<MenuTree> children = Lists.newArrayList();
		String extId="0";
		// 先找到所有的一级菜单
	    for (int i = 0; i < rootMenu.size(); i++) {
	        // 一级菜单
	        if (extId.equals(rootMenu.get(i).getParentId())) {
	        	Menu menu = rootMenu.get(i);
	            MenuTree mt = new MenuTree();
	          	mt.setId(menu.getId());
	          	mt.setLeaf(menu.getLeaf().equals("0")?false:true);
	          	mt.setText(menu.getName());
	          	mt.setIconCls(menu.getIcon());
	          	mt.setViewType(menu.getHref());
	          	mt.setParentId(menu.getParentId());
	        	mt.setIsShow(menu.getIsShow());
	        	mt.setSort( menu.getSort());
	        	children.add(mt);
	        	break;
	        }
	    }
	    
	    for(MenuTree menut : children){
	    	 menut.setChildren(getChild(menut.getId(), rootMenu));
	    }
        return renderString(response,children);
	}
	
	public void getJsonData(List<Map<String, Object>> mapList,List<Menu> sourceList,List<Menu> list){
		for(int i = 0 ; i < list.size() ;i++){
			Menu menu = list.get(i);
			//数据封装
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", menu.getId());
			map.put("leaf", menu.getLeaf().equals("0")?false:true);
			map.put("text", menu.getName());
			map.put("iconCls", menu.getIcon());
			map.put("viewType", menu.getHref());
			map.put("parentId", menu.getParentId());
			map.put("isShow", menu.getIsShow());
			map.put("sort", menu.getSort());
			String parentName = "";
			Menu entity = systemService.getMenu(menu.getParentId());
			if(null!=entity){
				parentName = entity.getName();
			}
			map.put("parentName",parentName);
			if(mapList.size()>0){
				//子菜单封装到mapList集合中
				getJsonTree(mapList,menu,map);
			}else{
				//装入跟目录
				mapList.add(map);
			}
			List<Menu> leaf = getChildMenu(sourceList,menu.getId());
			if(leaf.size()>0){
				getJsonData(mapList,sourceList,leaf);
			}
		}
	}
	
	//封装数据到mapList集合中
	public void getJsonTree(List<Map<String, Object>> mapList,Menu menu,Map<String, Object> map ){
		if(mapList!=null){
			for(int j = 0 ; j < mapList.size();j++){
				Map<String, Object> mp = mapList.get(j);
				List<Map<String, Object>> child = (List<Map<String, Object>>)mp.get("children");
				if(mp.get("id").equals(menu.getParentId())){
					if(child!=null&&child.size()>0){
						child.add(map);
					}else{
						List<Map<String, Object>> children = Lists.newArrayList();
//						if(j==0){
//							mp.put("expanded", true);
//		                }else{
		                	mp.put("expanded", false);
//		                }
						children.add(map);
						mp.put("children", children);
					}
				}else{
					getJsonTree(child,menu,map);
				}
			}
		}
	}
	
	//根据父节点获取子菜单
	public static List<Menu> getChildMenu(List<Menu> sourcelist,String parentId){
		List<Menu> list = Lists.newArrayList();
		for(int i = 0 ; i < sourcelist.size() ; i ++){
			Menu menu = sourcelist.get(i);
			if(menu.getParentId().equals(parentId)){
				list.add(menu);
			}
		}
		return list ;
	}
	
}
