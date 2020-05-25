package com.jsite.szy.dispatch.evaluation.web;

import com.jsite.busi.szy.evaluation.service.DdsWePService;
import com.jsite.core.web.BaseController;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-11-27 17:06
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/evaluation/preEval")
public class PreEvalController extends BaseController {

    @Autowired
    private DdsWePService ddsWePService;

    /**
     * 查询所有降水量评价数据
     * @param response
     * @return string
     */
    @ResponseBody
    @RequestMapping(value = {"/listAllToMap"})
    public String listAllToMap(HttpServletResponse response,
                               @RequestParam(value = "river") String river) throws Exception{
        return renderString(response, ddsWePService.listAllToMap_name(river));
    }

    @RequestMapping(value = "/getTemplate")
    public void getTemplate(HttpServletResponse response,
                                          @RequestParam(value = "river") String river) {
        response.setContentType("application/vnd.ms-excel");
        XSSFWorkbook wb = ddsWePService.getTemplate(river);
        setFileDownloadHeader(response, "降水量评价数据模版.xlsx");
        writeExcel(response, wb);
    }

    @RequestMapping(value = "/uploadData")
    public void uploadData(HttpServletResponse response,
                                    @RequestParam(value = "river") String river,
                                    @RequestParam(value = "uploadFile") MultipartFile file) {
        writeString(response, ddsWePService.uploadData(file, river));
    }

}
