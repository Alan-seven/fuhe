package com.jsite.szy.dispatch.dispatchwo.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsite.szy.dispatch.dispatchwo.vo.WaterOptimumVOMap;

public class ELEMapping {
	private HashMap<String, String> code;
	private HashMap<String, String> site;
	
	public ELEMapping() {
		code = new HashMap<>();
		site = new HashMap<>();
		
		Resource resource = new ClassPathResource("com/jsite/szy/dispatch/dispatchwo/model/eleMapping.json");
		if (resource.isReadable()){
			try {
				InputStream is = resource.getInputStream();
				ObjectMapper objectMapper = new ObjectMapper();
				WaterOptimumVOMap data = objectMapper.readValue(is, WaterOptimumVOMap.class);
				is.close();				
				
				List<LinkedHashMap<String, Object>> ref = (List<LinkedHashMap<String, Object>>) data.get("mapping");
				for(int i=0;i<ref.size();i++){
					LinkedHashMap<String, Object> map = ref.get(i);
					code.put((String)map.get("ref"), (String)map.get("comment"));
					site.put((String)map.get("comment"), (String)map.get("ref"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
			
		}
	}
	
	public String queryByCode(String code){
		return this.code.get(code.trim());
	}
	
	public String queryByELE(String ELE){
		return this.site.get(ELE.trim());
	}
}
