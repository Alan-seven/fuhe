package com.jsite.busi.szy.dispatch.service;

import com.jsite.busi.szy.common.ExcelService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWsahisDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWsahis;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-11-26 12:38
 */
@Service
public class WaterSupplyCalService {

    @Autowired
    private DdsRdWsahisDao ddsRdWsahisDao;


    public List<DdsRdWsahis> listAll(String river) {
        DdsRdWsahis d = new DdsRdWsahis();
        d.setRiver(river);
        return ddsRdWsahisDao.list(d);
    }

    /**
     * 导出模板
     * @return XSSFWorkbook
     */
    public XSSFWorkbook exportTemplate(String river) {

        String[][] headName = new String[][]{
                {"年份", "最大供水能力", "地表水资源", "天然径流量"},
                {"25", "20", "20", "20"}};

        XSSFWorkbook wb = new XSSFWorkbook();  				//--->创建了一个excel文件
        XSSFSheet sheet = wb.createSheet("可供水量计算数据模板");    //--->创建了一个工作簿

        // 列头
        ExcelService.initHeadSheet(wb, sheet, headName, 2);
        List<DdsRdWsahis> dataList = listAll(river);
        int bodyRow = 1;
        for (DdsRdWsahis d : dataList) {
            XSSFRow rowBody = sheet.createRow(bodyRow);
            XSSFCellStyle headStyle = ExcelService.setCellStyle(wb, 2);
            rowBody.setHeightInPoints(20); //head行高
            ExcelService.createCell(rowBody, 0, d.getYear(), headStyle);
            sheet.setColumnWidth(0, 256 * 20);

            ExcelService.createCell(rowBody, 1, d.getMwsc(), headStyle);
            sheet.setColumnWidth(1, 256 * 20);

            ExcelService.createCell(rowBody, 2, d.getSwr(), headStyle);
            sheet.setColumnWidth(2, 256 * 20);

            ExcelService.createCell(rowBody, 3, d.getNr(), headStyle);
            sheet.setColumnWidth(3, 256 * 20);
            bodyRow++;
        }
        return wb;
    }

    /**
     * 上传数据
     * @return boolean
     */
    public boolean uploadData(MultipartFile file, String river) {
        boolean isSuccess = false;
        XSSFSheet sheet;
        List<DdsRdWsahis> dataList = new ArrayList<>();
        try {
            InputStream filePath = file.getInputStream();
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(filePath);
            sheet = xssfWorkbook.getSheetAt(0); //默认从第一个获取
            if (sheet != null) {
                int firstRowNum = sheet.getFirstRowNum() + 1; // 数据从第二行开始
                int lastRowNum = sheet.getLastRowNum(); // 最后一行
                for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
                    DdsRdWsahis d = new DdsRdWsahis();
                    XSSFRow row = sheet.getRow(rowNum);
                    d.setYear(Double.valueOf(row.getCell(0).toString().trim()).intValue());
                    d.setMwsc(Double.valueOf(row.getCell(1).toString().trim()));
                    d.setSwr(Double.valueOf(row.getCell(2).toString().trim()));
                    d.setNr(Double.valueOf(row.getCell(3).toString().trim()));
                    d.setRiver(river);
                    dataList.add(d);
                }
            }
            for (DdsRdWsahis d : dataList) {
                DdsRdWsahis temp = ddsRdWsahisDao.get(d);
                if (temp != null) {
                    ddsRdWsahisDao.update(d);
                } else {
                    ddsRdWsahisDao.save(d);
                }
            }
            isSuccess = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }


}
