package com.jsite.szy.dispatch.dispatch.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.dispatch.po.CddsPRpar;
import com.jsite.busi.szy.dispatch.service.CddsPRparService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.dispatch.vo.CddsPRparVO;

/**
 * 需水预测方案信息Controller
 * @author 徐旺旺
 * @version 2017-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/cddsPRpar")
public class CddsPRparController extends BaseController {

	@Autowired
	private CddsPRparService cddsPRparService;
	
	/**
	 * 根据方案ID查询
	 * @param id
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		CddsPRparVO cddsPRparVO = new CddsPRparVO();
		if (StringUtils.isNotBlank(id)){
			CddsPRpar cddsPRpar = cddsPRparService.get(id);
			if (null != cddsPRpar) {
				cddsPRparVO = BeanMapper.map(cddsPRpar, cddsPRparVO.getClass());
			}
		}
		return renderString(response, cddsPRparVO);
	}
	
	/**
	 * 查询所有满足条件
	 * @param cddsPRparVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(CddsPRparVO cddsPRparVO, HttpServletResponse response) {
		CddsPRpar cddsPRpar = new CddsPRpar();
		if (null != cddsPRparVO) {
			BeanMapper.map(cddsPRparVO, cddsPRpar.getClass());
		}
		Page<CddsPRpar> page = cddsPRparService.getPage(new Page<CddsPRpar>(), cddsPRpar); 
		return  renderString(response, page);
	}

	/**
	 * 保存
	 * @param cddsPRparVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(CddsPRparVO cddsPRparVO, HttpServletResponse response) {
		CddsPRpar cddsPRpar = new CddsPRpar();
		if (null != cddsPRparVO) {
			cddsPRpar = BeanMapper.map(cddsPRparVO, cddsPRpar.getClass());
		}
		ServiceResp serviceResp = cddsPRparService.save(cddsPRpar);
		return renderString(response,serviceResp);
	}
	
	/**
	 * 修改
	 * @param cddsPRparVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(CddsPRparVO cddsPRparVO, HttpServletResponse response) {
		CddsPRpar cddsPRpar = new CddsPRpar();
		if (null != cddsPRparVO) {
			cddsPRpar = BeanMapper.map(cddsPRparVO, cddsPRpar.getClass());
		}
		ServiceResp serviceResp = cddsPRparService.update(cddsPRpar);
		return renderString(response,serviceResp);
	}
	
	/**
	 * 删除
	 * @param cddsPRparVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(CddsPRparVO cddsPRparVO, HttpServletResponse response) {
		CddsPRpar cddsPRpar = new CddsPRpar();
		if (null != cddsPRparVO) {
			cddsPRpar = BeanMapper.map(cddsPRparVO, cddsPRpar.getClass());
		}
		ServiceResp serviceResp = cddsPRparService.remove(cddsPRpar);
		return renderString(response,serviceResp);
	}

}