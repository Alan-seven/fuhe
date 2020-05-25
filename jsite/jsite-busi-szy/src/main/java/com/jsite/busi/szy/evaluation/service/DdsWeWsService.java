package com.jsite.busi.szy.evaluation.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.jsite.busi.szy.common.ExcelService;
import com.jsite.busi.szy.evaluation.dao.DdsWeWsDao;
import com.jsite.busi.szy.evaluation.po.DdsWeWrcs;
import com.jsite.busi.szy.evaluation.po.DdsWeWs;
import com.jsite.manager.AbstractCrudService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 供水量评价表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeWsService extends AbstractCrudService<DdsWeWsDao, DdsWeWs> {
    @Autowired
    DdsWeWsDao ddsWeWsDao;

    @Autowired
    private EvaluationService evaluationService;

    public Map<String, List<Map>> listAllToMap_name(String river) {
        List<String> regCds = evaluationService.getRegList(river);
        List<Map> dataList = ddsWeWsDao.listAllToMap(regCds);
        return EvaluationService.parseData(dataList);
    }

    public XSSFWorkbook getTemplate(String river) {
        String[][] headName = new String[][]{
            {
                "分区代码", "分区名称", "年份",
                "地表水蓄水", "地表水引水", "地表水提水",
                "地下水源供水量", "其他水源"
            },
            {"20", "20", "20", "20", "20", "20", "20", "20"}
        };

        XSSFWorkbook wb = new XSSFWorkbook();   //--->创建了一个excel文件
        XSSFSheet sheet = wb.createSheet("供水量评价数据模板");    //--->创建了一个工作簿

        // 列头
        ExcelService.initHeadSheet(wb, sheet, headName, 1);
        JsonNode node = ExcelService.readJson("wseTemp.json");
        evaluationService.setTemplateBody(node, wb, sheet);
        return wb;
    }

    public boolean uploadData(MultipartFile file, String river) {
        boolean isSuccess = false;
        XSSFSheet sheet;
        List<DdsWeWs> dataList = new ArrayList<>();
        Map<String, DdsWeWrcs> regMap = evaluationService.getRegMap(river);
        try {
            InputStream filePath = file.getInputStream();
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(filePath);
            sheet = xssfWorkbook.getSheetAt(0); //默认从第一个获取
            if (sheet != null) {
                int firstRowNum = sheet.getFirstRowNum() + 1; // 数据从第二行开始
                int lastRowNum = sheet.getLastRowNum(); // 最后一行
                for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
                    DdsWeWs d = new DdsWeWs();
                    XSSFRow row = sheet.getRow(rowNum);
                    if (row.getCell(0) != null) {
                        d.setRegCd(row.getCell(0).toString().trim());
                        d.setRegType(Long.valueOf(regMap.get(d.getRegCd()).getRegType()));
                    }
                    if (row.getCell(2) != null) {
                        d.setYr(String.valueOf(
                                Double.valueOf(
                                        row.getCell(2).toString().trim()).intValue()));
                    }
                    if (row.getCell(3) != null) {
                        d.setWspWs(Double.valueOf(
                                row.getCell(3).toString().trim()));
                    }
                    if (row.getCell(4) != null) {
                        d.setWdWs(Double.valueOf(
                                row.getCell(4).toString().trim()));
                    }
                    if (row.getCell(5) != null) {
                        d.setLpWs(Double.valueOf(row.getCell(5).toString().trim()));
                    }
                    if (row.getCell(6) != null) {
                        d.setUnder(Double.valueOf(
                                row.getCell(6).toString().trim()));
                    }
                    if (row.getCell(7) != null) {
                        d.setOther(Double.valueOf(row.getCell(7).toString().trim()));
                    }
                    d.setRiver(river);
                    dataList.add(d);
                }
            }
            for (DdsWeWs d : dataList) {
                DdsWeWs temp = this.get(d);
                if (temp != null) {
                    this.update(d);
                } else {
                    this.save(d);
                }
            }
            isSuccess = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}