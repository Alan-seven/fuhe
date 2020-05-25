package com.jsite.szy.dispatch.dispatch.web;

import com.jsite.busi.szy.dispatch.po.DdsRdWsa;
import com.jsite.busi.szy.dispatch.po.WaterAllocationData;
import com.jsite.busi.szy.dispatch.service.DdsRdWsaService;
import com.jsite.busi.szy.dispatch.service.WaterAllocationService;
import com.jsite.busi.szy.dispatch.service.WaterPredDataService;
import com.jsite.busi.szy.dispatch.service.WaterSupplyCalService;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.dispatch.vo.WaterPredRequestBody;
import com.jsite.szy.dispatch.dispatchwo.web.WaterDemandPredController;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-09-30 10:37
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch")
public class DefaultDataController extends BaseController {

    @Autowired
    private WaterSupplyCalService waterSupplyCalService;

    @Autowired
    private WaterPredDataService waterPredDataService;

    @Autowired
    private DdsRdWsaService ddsRdWsaService;

    @Autowired
    private WaterAllocationService waterAllocationService;

    // 抚河流域代码
    private static final String FH_RIVER_TYPE = "02";
    // 袁河流域代码
    private static final String YH_RIVER_TYPE = "03";

    @ResponseBody
    @RequestMapping(value = "fqData")
    public String getFqData(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(value = "river") String river) {
        return renderString(response, waterPredDataService.getFqData(river));
    }

    @ResponseBody
    @RequestMapping(value = "supplyCal/listAllHisData", method = RequestMethod.GET)
    public String listAllHisData(HttpServletResponse response, @RequestParam(value = "river") String river) {
        return renderString(response, waterSupplyCalService.listAll(river));
    }

    @RequestMapping(value = "supplyCal/getExcelTemplate")
    public void getSupplyCalExcelTemplate(HttpServletResponse response, @RequestParam(value = "river") String river) {
        response.setContentType("application/vnd.ms-excel");
        try {
            XSSFWorkbook wb = waterSupplyCalService.exportTemplate(river);
            setFileDownloadHeader(response, "可供水量计算数据模板.xlsx");
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "supplyCal/uploadData")
    public void uploadSupplyCalData(HttpServletResponse response,
                                    @RequestParam(value = "river") String river,
                                    @RequestParam(value = "uploadFile") MultipartFile file) {
        writeString(response, waterSupplyCalService.uploadData(file, river));
    }

    @ResponseBody
    @RequestMapping(value = "supplyCal/default")
    public String getSupplyCalData(HttpServletResponse response, @RequestParam(value = "proCd") String proCd) {
        DdsRdWsa p = new DdsRdWsa();
        p.setProCd(proCd);
        DdsRdWsa result = ddsRdWsaService.get(p);
        return renderString(response, result);
    }

    @ResponseBody
    @RequestMapping(value = "supplyCal/saveOrUpdate", method = RequestMethod.POST)
    public String supplyCalSaveOrUpdate(HttpServletRequest request, HttpServletResponse response,
                                        @RequestParam(value = "proCd") String proCd,
                                        @RequestBody DdsRdWsa data) {
        return renderString(response, ddsRdWsaService.saveOrUpdate(proCd, data));
    }

    @ResponseBody
    @RequestMapping(value = "waterPred/get")
    public String checkWaterPredData(HttpServletResponse response,
                                   @RequestParam(value = "proCd") String proCd,
                                   @RequestParam(value = "river") String river) {
        Map<String, Object> result = waterPredDataService.selectDataByProCd(proCd);
        return renderString(response, result);
    }

    @ResponseBody
    @RequestMapping(value = "waterPred/default")
    public String getWaterPredData(HttpServletResponse response,
                                   @RequestParam(value = "proCd") String proCd,
                                   @RequestParam(value = "river") String river) {
        Map<String, Object> result = waterPredDataService.selectDataByProCd(proCd);
        if (result == null) {
            String path = "";
            if (FH_RIVER_TYPE.equals(river)) {
                path = "defaultData/FH_WaterPredDefault.json";
            } else if (YH_RIVER_TYPE.equals(river)) {
                path = "defaultData/YH_WaterPredDefault.json";
            }
            String jsonStr = WaterDemandPredController.readJsonStr(ResourceUtils.CLASSPATH_URL_PREFIX + path);
            return renderString(response, jsonStr, "application/json");
        } else {
            return renderString(response, result);
        }
    }

    @ResponseBody
    @RequestMapping(value = "waterPred/saveOrUpdate", method = RequestMethod.POST)
    public String waterPredSaveOrUpdate(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "proCd") String proCd,
                        @RequestBody WaterPredRequestBody data) {
        boolean state = waterPredDataService.saveOrUpdate(proCd,
                data.getP1(),
                data.getP2(),
                data.getP3(),
                data.getP4(),
                data.getP5(),
                data.getP6(),
                data.getP7());
        return renderString(response, state);
    }

    @ResponseBody
    @RequestMapping(value = "waterAllocation/get")
    public String checkWaterAllocationData(HttpServletResponse response,
                                         @RequestParam(value = "proCd") String proCd) {
        return renderString(response, waterAllocationService.checkSaveData(proCd));
    }

    @ResponseBody
    @RequestMapping(value = "waterAllocation/default")
    public String getWaterAllocationData(HttpServletResponse response,
                                        @RequestParam(value = "proCd") String proCd,
                                        @RequestParam(value = "type") String type) {
        return renderString(response, waterAllocationService.getDefaultData(proCd, type));
    }

    @ResponseBody
    @RequestMapping(value = "waterAllocation/clac", method = RequestMethod.POST)
    public String getWaterAllocationCalcData(HttpServletResponse response,
                                             @RequestParam(value = "proCd") String proCd,
                                             @RequestParam(value = "type") String type,
                                             @RequestBody WaterAllocationData data) {
        return renderString(response, waterAllocationService.calc(data, proCd, type));
    }

    @ResponseBody
    @RequestMapping(value = "waterAllocation/saveOrUpdate", method = RequestMethod.POST)
    public String waterAllocationSaveOrUpdate(HttpServletRequest request, HttpServletResponse response,
                                        @RequestParam(value = "proCd") String proCd,
                                        @RequestParam(value = "type") String type,
                                        @RequestBody WaterAllocationData data) {
        return renderString(response, waterAllocationService.saveOrUpdate(data, proCd, type));
    }

}
