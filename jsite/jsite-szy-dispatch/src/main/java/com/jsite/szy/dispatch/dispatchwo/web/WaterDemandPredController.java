package com.jsite.szy.dispatch.dispatchwo.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-09-13 09:42
 * 需水预测样例数据
 */
public class WaterDemandPredController {
	private static ObjectMapper objectMapper;
	
	static {
        objectMapper = new ObjectMapper();
    }
	
	public static String readJsonStr(String path) {
        String jsonStr = null;
        try {
            JsonNode rootNode = objectMapper.readTree(ResourceUtils.getFile(path));
            jsonStr = rootNode.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonStr;
    }
	
}
