package com.jsite.szy.dispatch.evaluation.web;

import com.jsite.busi.szy.evaluation.service.DdsWeDaService;
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
@RequestMapping(value = "${adminPath}/szy/evaluation/wde")
public class WdeController extends BaseController {

    @Autowired
    private DdsWeDaService ddsWeDaService;

    @ResponseBody
    @RequestMapping(value = "/listAllToMap")
    public String getTest(HttpServletResponse response,
                          @RequestParam(value = "river") String river) throws Exception{
        return renderString(response, ddsWeDaService.listAllToMap_name(river));
    }

    @RequestMapping(value = "/getTemplate")
    public void getTemplate(HttpServletResponse response,
                                          @RequestParam(value = "river") String river) {
        response.setContentType("application/vnd.ms-excel");
        XSSFWorkbook wb = ddsWeDaService.getTemplate(river);
        setFileDownloadHeader(response, "废污水排放量评价数据模板.xlsx");
        writeExcel(response, wb);
    }

    @RequestMapping(value = "/uploadData")
    public void uploadData(HttpServletResponse response,
                                    @RequestParam(value = "river") String river,
                                    @RequestParam(value = "uploadFile") MultipartFile file) {
        writeString(response, ddsWeDaService.uploadData(file, river));
    }

}
