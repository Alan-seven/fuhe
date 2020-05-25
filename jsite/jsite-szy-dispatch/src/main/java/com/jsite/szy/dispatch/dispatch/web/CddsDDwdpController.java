package com.jsite.szy.dispatch.dispatch.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.dispatch.po.CddsDDwdp;
import com.jsite.busi.szy.dispatch.service.CddsDDwdpService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.dispatch.vo.CddsDDwdpVO;

/**
 * 生活需水基础数据Controller
 * @author 徐旺旺
 * @version 2017-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/cddsDDwdp")
public class CddsDDwdpController extends BaseController {

	@Autowired
	private CddsDDwdpService cddsDDwdpService;
	
	/**
	 * 根据条件查询
	 * @param wrcsCd
	 * @param proCd
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String wrcsCd,String proCd, HttpServletResponse response) {
		CddsDDwdpVO cddsDDwdpVO = new CddsDDwdpVO();
		CddsDDwdp cddsDDwdp = new CddsDDwdp();
		if (StringUtils.isNotBlank(wrcsCd)&&StringUtils.isNotBlank(proCd)){
			cddsDDwdp.setWrcsCd(wrcsCd);
			cddsDDwdp.setProCd(proCd);
		    cddsDDwdp = cddsDDwdpService.get(cddsDDwdp);
			if (null != cddsDDwdp) {
				cddsDDwdpVO = BeanMapper.map(cddsDDwdp, cddsDDwdpVO.getClass());
			}
		}
		return renderString(response, cddsDDwdpVO);
	}
	
	/**
	 * 查询所有
	 * @param cddsDDwdpVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(CddsDDwdpVO cddsDDwdpVO, HttpServletResponse response) {
		CddsDDwdp cddsDDwdp = new CddsDDwdp();
		if (null != cddsDDwdpVO) {
			cddsDDwdp = BeanMapper.map(cddsDDwdpVO, cddsDDwdp.getClass());
		}
		Page<CddsDDwdp> page = cddsDDwdpService.getPage(new Page<CddsDDwdp>(), cddsDDwdp); 
		return  renderString(response, page);
	}

	/**
	 * 批量新增
	 * @param cddsDDwdpList
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(@RequestBody List<CddsDDwdpVO> cddsDDwdpList, HttpServletResponse response) {
		CddsDDwdp cddsDDwdp = new CddsDDwdp();
		ServiceResp serviceResp = null ;
		if(cddsDDwdpList!=null){
			for(CddsDDwdpVO cddsDDwdpVO : cddsDDwdpList){
				if (null != cddsDDwdpVO) {
					cddsDDwdp = BeanMapper.map(cddsDDwdpVO, cddsDDwdp.getClass());
				}
				serviceResp = cddsDDwdpService.save(cddsDDwdp);
			}
		}
		return renderString(response,serviceResp);
	}
	
	/**
	 * 批量修改
	 * @param cddsDDwdpList
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(@RequestBody List<CddsDDwdpVO> cddsDDwdpList, HttpServletResponse response) {
		CddsDDwdp cddsDDwdp = new CddsDDwdp();
		ServiceResp serviceResp = null ;
		if(cddsDDwdpList!=null){
			for(CddsDDwdpVO cddsDDwdpVO : cddsDDwdpList){
				if (null != cddsDDwdpVO) {
					cddsDDwdp = BeanMapper.map(cddsDDwdpVO, cddsDDwdp.getClass());
				}
				serviceResp = cddsDDwdpService.update(cddsDDwdp);
			}
		}
		return renderString(response,serviceResp);
	}
	
	/**
	 * 单个entity删除
	 * @param cddsDDwdpVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(CddsDDwdpVO cddsDDwdpVO, HttpServletResponse response) {
		CddsDDwdp cddsDDwdp = new CddsDDwdp();
		if (null != cddsDDwdpVO) {
			cddsDDwdp = BeanMapper.map(cddsDDwdpVO, cddsDDwdp.getClass());
		}
		ServiceResp serviceResp = cddsDDwdpService.remove(cddsDDwdp);
		return renderString(response,serviceResp);
	}

}