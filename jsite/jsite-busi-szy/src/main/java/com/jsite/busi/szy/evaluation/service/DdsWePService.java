package com.jsite.busi.szy.evaluation.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.jsite.busi.szy.common.ExcelService;
import com.jsite.busi.szy.evaluation.dao.DdsWePDao;
import com.jsite.busi.szy.evaluation.po.DdsWeP;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 降水量评价表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWePService extends AbstractCrudService<DdsWePDao, DdsWeP> {

    @Autowired
    DdsWePDao ddsWePDao;

    @Autowired
    private EvaluationService evaluationService;

    public Map<String, List<Map>> listAllToMap_name(String river) {
        List<String> regCds = evaluationService.getRegList(river);
        List<Map> dataList = ddsWePDao.listAllToMap(regCds);
        return EvaluationService.parseData(dataList);
    }

    public XSSFWorkbook getTemplate(String river) {
        String[][] headName = new String[][]{
                {"分区代码", "分区名称", "计算面积（平方公里）", "年份", "年降水深（mm）", "年降水量（亿m³）",
                        "上年降水量（亿m³）", "与上年比较（%）", "多年平均（mm）", "与多年平均比较（%）"},
                {"20", "20", "25", "20", "20", "20", "20", "20", "20", "20"}};

        XSSFWorkbook wb = new XSSFWorkbook();   //--->创建了一个excel文件
        XSSFSheet sheet = wb.createSheet("降水量评价数据模板");    //--->创建了一个工作簿

        // 列头
        ExcelService.initHeadSheet(wb, sheet, headName, 1);
        JsonNode node = ExcelService.readJson("preEvalTemp.json");
        evaluationService.setTemplateBody(node, wb, sheet);

        return wb;
    }

    public boolean uploadData(MultipartFile file, String river) {
        boolean isSuccess = false;
        XSSFSheet sheet;
        List<DdsWeP> dataList = new ArrayList<>();
        Map<String, DdsWeWrcs> regMap = evaluationService.getRegMap(river);
        try {
            InputStream filePath = file.getInputStream();
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(filePath);
            sheet = xssfWorkbook.getSheetAt(0); //默认从第一个获取
            if (sheet != null) {
                int firstRowNum = sheet.getFirstRowNum() + 1; // 数据从第二行开始
                int lastRowNum = sheet.getLastRowNum(); // 最后一行
                for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
                    DdsWeP d = new DdsWeP();
                    XSSFRow row = sheet.getRow(rowNum);
                    if (row.getCell(0) != null) {
                        d.setRegCd(row.getCell(0).toString().trim());
                        d.setRegType(Long.valueOf(regMap.get(d.getRegCd()).getRegType()));
                    }
                    if (row.getCell(2) != null) {
                        d.setArea(new BigDecimal(
                                row.getCell(2).toString().trim()));
                    }
                    if (row.getCell(3) != null) {
                        d.setYr(String.valueOf(Double.valueOf(
                                row.getCell(3).toString().trim()).intValue()));
                    }
                    if (row.getCell(4) != null) {
                        d.setCurPd(Double.valueOf(row.getCell(4).toString().trim()));
                    }
                    if (row.getCell(5) != null) {
                        d.setCurP(Double.valueOf(row.getCell(5).toString().trim()));
                    }
                    if (row.getCell(6) != null) {
                        d.setLyP(Double.valueOf(row.getCell(6).toString().trim()));
                    }
                    if (row.getCell(7) != null) {
                        d.setAnnP(Double.valueOf(row.getCell(7).toString().trim()));
                    }
                    if (row.getCell(8) != null) {
                        d.setLyRt(Double.valueOf(row.getCell(8).toString().trim()));
                    }
                    if (row.getCell(9) != null) {
                        d.setAnnRt(Double.valueOf(row.getCell(9).toString().trim()));
                    }
                    d.setRiver(river);
                    dataList.add(d);
                }
            }
            for (DdsWeP d : dataList) {
                DdsWeP temp = ddsWePDao.get(d);
                if (temp != null) {
                    ddsWePDao.update(d);
                } else {
                    ddsWePDao.save(d);
                }
            }
            isSuccess = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

}