package com.jsite.szy.dispatch.dispatch.web;

import com.jsite.busi.szy.evaluation.service.DdsWeWsService;
import com.jsite.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 向靖
 * 创建时间：2017-09-29 14:13
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/ddsWeWs")
public class DdsWeWsController extends BaseController{

    @Autowired
    DdsWeWsService ddsWeWsService;

    @ResponseBody
    @RequestMapping(value = {"listAllToMap"})
    public String listAllToMap(HttpServletResponse response,
                               @RequestParam(value = "river") String river) throws Exception{
        return renderString(response, ddsWeWsService.listAllToMap_name(river));
    }


}
