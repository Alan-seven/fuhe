package com.jsite.szy.dispatch.sys.web;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.client.util.AssertionHolder;
import org.jsite.si.CasUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.jsite.busi.szy.sys.service.UserInfoService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.dao.sys.po.DdsSysUserinfo;
import com.jsite.szy.dispatch.sys.vo.DdsSysUserinfoVO;

import cn.com.dhcc.uums.service.uums.UserInfo;

/**
 * 人员信息表Controller
 * @author hjx
 * @version 2017-09-12
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/sys/user")
public class DdsSysUserinfoController extends BaseController {

	@Autowired
	private UserInfoService ddsSysUserinfoService;
	
	@ResponseBody
	@RequestMapping(value = { "getCurrent", "" })
	public String getCurrent(HttpServletResponse response) {
		UserInfo ui = CasUtils.getCurrentUser();
		return renderString(response, ui);
	}
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String userCode, HttpServletResponse response) {
		DdsSysUserinfoVO ddsSysUserinfoVO = new DdsSysUserinfoVO();
		if (StringUtils.isNotBlank(userCode)){
			DdsSysUserinfo ddsSysUserinfo = ddsSysUserinfoService.get(userCode);
			if (null != ddsSysUserinfo) {
				ddsSysUserinfoVO = BeanMapper.map(ddsSysUserinfo, ddsSysUserinfoVO.getClass());
			}
		}
		return renderString(response, ddsSysUserinfoVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsSysUserinfoVO ddsSysUserinfoVO, HttpServletResponse response) {
		DdsSysUserinfo ddsSysUserinfo = new DdsSysUserinfo();
		if (null != ddsSysUserinfoVO) {
			ddsSysUserinfo = BeanMapper.map(ddsSysUserinfoVO, ddsSysUserinfo.getClass());
		}
		Page<DdsSysUserinfo> page = ddsSysUserinfoService.getPage(new Page<DdsSysUserinfo>(), ddsSysUserinfo); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsSysUserinfoVO ddsSysUserinfoVO, HttpServletResponse response) {
		DdsSysUserinfo ddsSysUserinfo = new DdsSysUserinfo();
		if (null != ddsSysUserinfoVO) {
			ddsSysUserinfo = BeanMapper.map(ddsSysUserinfoVO, ddsSysUserinfo.getClass());
		}
		ServiceResp serviceResp = ddsSysUserinfoService.save(ddsSysUserinfo);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsSysUserinfoVO ddsSysUserinfoVO, HttpServletResponse response) {
		DdsSysUserinfo ddsSysUserinfo = new DdsSysUserinfo();
		if (null != ddsSysUserinfoVO) {
			ddsSysUserinfo = BeanMapper.map(ddsSysUserinfoVO, ddsSysUserinfo.getClass());
		}
		ServiceResp serviceResp = ddsSysUserinfoService.update(ddsSysUserinfo);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSysUserinfoVO ddsSysUserinfoVO, HttpServletResponse response) {
		DdsSysUserinfo ddsSysUserinfo = new DdsSysUserinfo();
		if (null != ddsSysUserinfoVO) {
			ddsSysUserinfo = BeanMapper.map(ddsSysUserinfoVO, ddsSysUserinfo.getClass());
		}
		ServiceResp serviceResp = ddsSysUserinfoService.remove(ddsSysUserinfo);
		return renderString(response,serviceResp);
	}

	/**
	 * 保存用户角色关系
	 * @param ddsSysUserinfoVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateRole")
	public String updateRole(DdsSysUserinfoVO ddsSysUserinfoVO, HttpServletResponse response) {
		DdsSysUserinfo ddsSysUserinfo = new DdsSysUserinfo();
		if (null != ddsSysUserinfoVO) {
			ddsSysUserinfo = BeanMapper.map(ddsSysUserinfoVO, ddsSysUserinfo.getClass());
		}
		ServiceResp serviceResp = ddsSysUserinfoService.saveUserDORole(ddsSysUserinfo);
		//推送角色列表至统一用户
		/*if(serviceResp.getCode()==1){
			try {
				UumsServiceImplService uumsService =  new UumsServiceImplServiceLocator();
				UumsServiceImplServiceSoapBindingStub binding = (UumsServiceImplServiceSoapBindingStub)uumsService.getUumsServiceImplPort();
				
				List<Role> roleList = ddsSysUserinfo.getRoleDOList();
				List<RoleInfo> pubriList = Lists.newArrayList();
				List<RoleInfo> updateriList = Lists.newArrayList();
				for(int i = 0 ; i < roleList.size();i++ ){
					Role role = roleList.get(i);
					RoleInfo rInfo = new RoleInfo();
					rInfo.setRoleCode(role.getId());
					Role entity = systemService.getRole(role.getId());
					rInfo.setRoleName(entity.getName());
					DdsSysUserinfo userInfo = ddsSysUserinfoService.get(ddsSysUserinfo.getUserCode());
					rInfo.setScode("dispat02");
					rInfo.setRoleType(entity.getRoleType());
					rInfo.setModifier(ddsSysUserinfo.getUserCode());
					RoleInfo roleInfo = binding.getRoleInfo(role.getId(), "dispat02");
					if(roleInfo!=null){
						updateriList.add(rInfo);
					}else{
						pubriList.add(rInfo);
					}
				}
				if(pubriList.size()>0){
					int code = binding.pushRoleInfo(pubriList.toArray(new RoleInfo[pubriList.size()]));
					System.out.println("角色推送成功个数："+code);
				}
				if(updateriList.size()>0){
					int code = binding.updateRoleInfo(updateriList.toArray(new RoleInfo[updateriList.size()]));
					System.out.println("角色更新推送成功个数："+code);
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
		}*/
		
		
		return renderString(response,serviceResp);
	}
}