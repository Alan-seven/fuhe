package com.jsite.busi.szy.evaluation.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.jsite.busi.szy.common.ExcelService;
import com.jsite.busi.szy.evaluation.dao.DdsWeDaDao;
import com.jsite.busi.szy.evaluation.po.DdsWeDa;
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
 * 废污水排放量评价表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeDaService extends AbstractCrudService<DdsWeDaDao, DdsWeDa> {


    @Autowired
    DdsWeDaDao ddsWeDaDao;

    @Autowired
    private EvaluationService evaluationService;

    public Map<String, List<Map>> listAllToMap_name(String river) {
        List<String> regCds = evaluationService.getRegList(river);
        List<Map> dataList = ddsWeDaDao.listAllToMap(regCds);
        return EvaluationService.parseData(dataList);
    }

    public XSSFWorkbook getTemplate(String river) {
        String[][] headName = new String[][]{
            {
                "分区代码", "分区名称", "年份", "面积",
                "城镇居民生活污水排放量", "工业废水排放量", "建筑业废水排放量",
                "第三产业废水排放量", "火电厂直流式冷却水排放量", "矿坑排放量"
            },
            {"20", "20", "20", "20", "25", "25", "25", "25", "25", "25"}
        };

        XSSFWorkbook wb = new XSSFWorkbook();   //--->创建了一个excel文件
        XSSFSheet sheet = wb.createSheet("废污水排放量评价数据模板");    //--->创建了一个工作簿

        // 列头
        ExcelService.initHeadSheet(wb, sheet, headName, 1);
        JsonNode node = ExcelService.readJson("wdeTemp.json");
        evaluationService.setTemplateBody(node, wb, sheet);
        return wb;
    }

    public boolean uploadData(MultipartFile file, String river) {
        boolean isSuccess = false;
        XSSFSheet sheet;
        List<DdsWeDa> dataList = new ArrayList<>();
        Map<String, DdsWeWrcs> regMap = evaluationService.getRegMap(river);
        try {
            InputStream filePath = file.getInputStream();
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(filePath);
            sheet = xssfWorkbook.getSheetAt(0); //默认从第一个获取
            if (sheet != null) {
                int firstRowNum = sheet.getFirstRowNum() + 1; // 数据从第二行开始
                int lastRowNum = sheet.getLastRowNum(); // 最后一行
                for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
                    DdsWeDa d = new DdsWeDa();
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
                        d.setArea(Double.valueOf(
                                row.getCell(3).toString().trim()));
                    }
                    if (row.getCell(4) != null) {
                        d.setTownLifeDa(Double.valueOf(
                                row.getCell(4).toString().trim()));
                    }
                    if (row.getCell(5) != null) {
                        d.setIndSewDa(Double.valueOf(
                                row.getCell(5).toString().trim()));
                    }
                    if (row.getCell(6) != null) {
                        d.setBldDa(Double.valueOf(row.getCell(6).toString().trim()));
                    }
                    if (row.getCell(7) != null) {
                        d.setSrvDa(Double.valueOf(
                                row.getCell(7).toString().trim()));
                    }
                    if (row.getCell(8) != null) {
                        d.setIeyDa(Double.valueOf(row.getCell(8).toString().trim()));
                    }
                    if (row.getCell(9) != null) {
                        d.setImyDa(Double.valueOf(row.getCell(9).toString().trim()));
                    }
                    d.setRiver(river);
                    dataList.add(d);
                }
            }
            for (DdsWeDa d : dataList) {
                DdsWeDa temp = this.get(d);
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