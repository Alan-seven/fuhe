package com.jsite.busi.szy.evaluation.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.jsite.busi.szy.common.ExcelService;
import com.jsite.busi.szy.evaluation.dao.DdsWeWrcsDao;
import com.jsite.busi.szy.evaluation.po.DdsWeWrcs;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-11-01 09:38
 */
@Service
public class EvaluationService {

    @Autowired
    private DdsWeWrcsDao ddsWeWrcsDao;

    public List<String> getRegList(String river) {
        DdsWeWrcs condition = new DdsWeWrcs();
        condition.setRiver(river);
        List<DdsWeWrcs> dataList = ddsWeWrcsDao.list(condition);
        List<String> regCdList = new ArrayList<>();
        for (DdsWeWrcs d : dataList) {
            regCdList.add(d.getRegCd());
        }
        return regCdList;
    }

    public Map<String, DdsWeWrcs> getRegMap(String river) {
        DdsWeWrcs condition = new DdsWeWrcs();
        condition.setRiver(river);
        List<DdsWeWrcs> regList = ddsWeWrcsDao.list(condition);
        Map<String, DdsWeWrcs> map = new HashMap<>();
        for (DdsWeWrcs d : regList) {
            map.put(d.getRegCd(), d);
        }
        return map;
    }

    public void setTemplateBody(JsonNode arrayNode, XSSFWorkbook wb, XSSFSheet sheet) {
        Iterator<JsonNode> nodeRow = arrayNode.elements();
        int bodyRow = 1;
        while (nodeRow.hasNext()) {
            int rowColumnNum = 0;
            XSSFRow rowBody = sheet.createRow(bodyRow);
            XSSFCellStyle headStyle = ExcelService.setCellStyle(wb, 2);
            rowBody.setHeightInPoints(20); //head行高
            ArrayNode jsonNode = (ArrayNode) nodeRow.next();
            Iterator<JsonNode> element = jsonNode.elements();
            while (element.hasNext()) {
                String val = element.next().textValue();
                ExcelService.createCell(rowBody, rowColumnNum, val, headStyle);
                sheet.setColumnWidth(0, 256 * 20);
                rowColumnNum++;
            }
            bodyRow++;
        }
    }

    public static Map<String, List<Map>> parseData(List<Map> dataList) {
        Map<String, List<Map>> dataMap = new HashMap<>();
        if (dataList != null) {
            List<Map> list;
            for (Map d : dataList) {
                if (!dataMap.containsKey(d.get("yr"))) {
                    list = new ArrayList<>();
                    dataMap.put(d.get("yr").toString(), list);
                } else {
                    list = dataMap.get(d.get("yr").toString());
                }
                list.add(d);
            }
        }
        return dataMap;
    }
}
