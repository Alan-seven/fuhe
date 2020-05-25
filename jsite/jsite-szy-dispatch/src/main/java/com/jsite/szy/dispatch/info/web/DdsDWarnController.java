package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsDStz;
import com.jsite.busi.szy.info.po.DdsDWarn;
import com.jsite.busi.szy.info.service.DdsDWarnService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsDStzVO;
import com.jsite.szy.dispatch.info.vo.DdsDWarnVO;

/**
 * 测站水位预警信息表Controller
 * @author hjx
 * @version 2017-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/warn")
public class DdsDWarnController extends BaseController {

	@Autowired
	private DdsDWarnService ddsDWarnService;
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsDWarnVO ddsDWarnVO, HttpServletResponse response) {
		DdsDWarn ddsDWarn = new DdsDWarn();
		if (null != ddsDWarnVO) {
			ddsDWarn = BeanMapper.map(ddsDWarnVO, ddsDWarn.getClass());
		}
		Page<DdsDWarn> page = ddsDWarnService.getPage(new Page<DdsDWarn>(ddsDWarnVO.getPageNo(),ddsDWarnVO.getPageSize()), ddsDWarn); 
		return  renderString(response, page);
	}
	
}
