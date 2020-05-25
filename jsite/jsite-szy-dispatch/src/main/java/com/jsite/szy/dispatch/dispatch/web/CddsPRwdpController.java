package com.jsite.szy.dispatch.dispatch.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.dispatch.po.CddsPRwdp;
import com.jsite.busi.szy.dispatch.service.CddsPRwdpService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.dispatch.vo.CddsDDwdpVO;
import com.jsite.szy.dispatch.dispatch.vo.CddsPRwdpVO;

/**
 * 居民需水计算Controller
 * @author 徐旺旺
 * @version 2017-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/cddsPRwdp")
public class CddsPRwdpController extends BaseController {

	@Autowired
	private CddsPRwdpService cddsPRwdpService;
	
	/**
	 * 根据方案ID 、用水区域ID查询
	 * @param proCd
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String proCd,String wrcsCd, HttpServletResponse response) {
		CddsPRwdpVO cddsPRwdpVO = new CddsPRwdpVO();
		if (StringUtils.isNotBlank(proCd)&& StringUtils.isNoneBlank(wrcsCd)){
			CddsPRwdp cddsPRwdp = new CddsPRwdp();
			cddsPRwdp.setProCd(proCd);
			cddsPRwdp.setWrcsCd(wrcsCd);
			cddsPRwdp = cddsPRwdpService.get(cddsPRwdp);
			if (null != cddsPRwdp) {
				cddsPRwdpVO = BeanMapper.map(cddsPRwdp, cddsPRwdpVO.getClass());
			}
		}
		return renderString(response, cddsPRwdpVO);
	}
	
	/**
	 * 查询 所有 分页
	 * @param cddsPRwdpVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(CddsPRwdpVO cddsPRwdpVO, HttpServletResponse response) {
		CddsPRwdp cddsPRwdp = new CddsPRwdp();
		if (null != cddsPRwdpVO) {
			cddsPRwdp = BeanMapper.map(cddsPRwdpVO, cddsPRwdp.getClass());
		}
		Page<CddsPRwdp> page = cddsPRwdpService.getPage(new Page<CddsPRwdp>(), cddsPRwdp); 
		return  renderString(response, page);
	}

	/**
	 * 批量新增
	 * @param cddsPRwdpVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(@RequestBody List<CddsPRwdpVO> cddsPRwdpList, HttpServletResponse response) {
		CddsPRwdp cddsPRwdp = new CddsPRwdp();
		ServiceResp serviceResp = null ;
		if(cddsPRwdpList!=null){
			for(CddsPRwdpVO cddsPRwdpVO : cddsPRwdpList){
				if (null != cddsPRwdpVO) {
					cddsPRwdp = BeanMapper.map(cddsPRwdpVO, cddsPRwdp.getClass());
				}
				serviceResp = cddsPRwdpService.save(cddsPRwdp);
			}
		}
		return renderString(response,serviceResp);
	}
	
	/**
	 * 批量修改
	 * @param cddsPRwdpVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(@RequestBody List<CddsPRwdpVO> cddsPRwdpList, HttpServletResponse response) {
		CddsPRwdp cddsPRwdp = new CddsPRwdp();
		ServiceResp serviceResp = null ;
		if(cddsPRwdpList!=null){
			for(CddsPRwdpVO cddsPRwdpVO : cddsPRwdpList){
				if (null != cddsPRwdpVO) {
					cddsPRwdp = BeanMapper.map(cddsPRwdpVO, cddsPRwdp.getClass());
				}
			 serviceResp = cddsPRwdpService.update(cddsPRwdp);
			}
		}
		return renderString(response,serviceResp);
	}
	
	/**
	 * 执行单个entity 
	 * @param cddsPRwdpVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(CddsPRwdpVO cddsPRwdpVO, HttpServletResponse response) {
		CddsPRwdp cddsPRwdp = new CddsPRwdp();
		if (null != cddsPRwdpVO) {
			cddsPRwdp = BeanMapper.map(cddsPRwdpVO, cddsPRwdp.getClass());
		}
		ServiceResp serviceResp = cddsPRwdpService.remove(cddsPRwdp);
		return renderString(response,serviceResp);
	}

}