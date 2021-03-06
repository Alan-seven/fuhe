package com.jsite.busi.szy.evaluation.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.jsite.busi.szy.common.ExcelService;
import com.jsite.busi.szy.evaluation.dao.DdsWeRsDao;
import com.jsite.busi.szy.evaluation.po.DdsWeRs;
import com.jsite.busi.szy.evaluation.po.DdsWeWrcs;
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
 * 水库蓄水动态评价表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeRsService extends AbstractCrudService<DdsWeRsDao, DdsWeRs> {

    @Autowired
    DdsWeRsDao ddsWeRsDao;

    @Autowired
    private EvaluationService evaluationService;

    public Map<String, List<Map>> listAllToMap_name(String river) {
        List<String> regCds = evaluationService.getRegList(river);
        List<Map> dataList = ddsWeRsDao.listAllToMap_name(regCds);
        return EvaluationService.parseData(dataList);
    }

    public XSSFWorkbook getTemplate(String river) {
        String[][] headName = new String[][]{
                {
                        "分区代码", "分区名称", "年份",
                        "中型水库座数", "中型水库年初蓄水总量", "中型水库年末蓄水总量",
                        "大型水库座数", "大型水库年初蓄水总量", "大型水库年末蓄水总量"
                },
                {"20", "20", "20", "20", "20", "20", "20", "20", "20", "20", "20"}};

        XSSFWorkbook wb = new XSSFWorkbook();   //--->创建了一个excel文件
        XSSFSheet sheet = wb.createSheet("蓄水动态评价数据模板");    //--->创建了一个工作簿

        // 列头
        ExcelService.initHeadSheet(wb, sheet, headName, 1);

        JsonNode node = ExcelService.readJson("dewsTemp.json");
        evaluationService.setTemplateBody(node, wb, sheet);

        return wb;
    }

    public boolean uploadData(MultipartFile file, String river) {
        boolean isSuccess = false;
        XSSFSheet sheet;
        List<DdsWeRs> dataList = new ArrayList<>();
        Map<String, DdsWeWrcs> regMap = evaluationService.getRegMap(river);
        try {
            InputStream filePath = file.getInputStream();
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(filePath);
            sheet = xssfWorkbook.getSheetAt(0); //默认从第一个获取
            if (sheet != null) {
                int firstRowNum = sheet.getFirstRowNum() + 1; // 数据从第二行开始
                int lastRowNum = sheet.getLastRowNum(); // 最后一行
                for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
                    DdsWeRs d = new DdsWeRs();
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
                        d.setMidResNum(Double.valueOf(
                                row.getCell(3).toString().trim()).intValue());
                    }
                    if (row.getCell(4) != null) {
                        d.setMidResYsw(Double.valueOf(
                                row.getCell(4).toString().trim()));
                    }
                    if (row.getCell(5) != null) {
                        d.setMidResYew(Double.valueOf(row.getCell(5).toString().trim()));
                    }
                    if (row.getCell(6) != null) {
                        d.setLarResNum(Double.valueOf(
                                row.getCell(6).toString().trim()).intValue());
                    }
                    if (row.getCell(7) != null) {
                        d.setLarResYsw(Double.valueOf(row.getCell(7).toString().trim()));
                    }
                    if (row.getCell(8) != null) {
                        d.setLarResYew(Double.valueOf(row.getCell(8).toString().trim()));
                    }
                    d.setRiver(river);
                    dataList.add(d);
                }
            }
            for (DdsWeRs d : dataList) {
                DdsWeRs temp = this.get(d);
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