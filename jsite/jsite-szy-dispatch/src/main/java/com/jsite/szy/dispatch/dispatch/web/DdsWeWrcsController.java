package com.jsite.szy.dispatch.dispatch.web;

import com.jsite.busi.szy.evaluation.service.DdsWeWrcsService;
import com.jsite.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-09-19 16:26
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/ddsWeWrcs")
public class DdsWeWrcsController extends BaseController {

    @Autowired
    private DdsWeWrcsService ddsWeWrcsService;

    /**
     * 查询所有蓄水动态评价数据
     * @param response
     * @return string
     */
    @ResponseBody
    @RequestMapping(value = {"list", ""})
    public String listAll(HttpServletResponse response) {
        return renderString(response, ddsWeWrcsService.list(null));
    }

}
