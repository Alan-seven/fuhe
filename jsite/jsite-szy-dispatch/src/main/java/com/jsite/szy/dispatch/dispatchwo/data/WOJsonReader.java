package com.jsite.szy.dispatch.dispatchwo.data;

import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsite.szy.dispatch.dispatchwo.vo.WaterOptimumVOMap;

public class WOJsonReader {
	private Logger logger = LogManager.getLogger(this.getClass().getName());
	private ObjectMapper objectMapper;
	
	public WOJsonReader() {
		objectMapper = new ObjectMapper();
	}
	
	public WaterOptimumVOMap read(String path){
		WaterOptimumVOMap output = null;
		Resource resource = new ClassPathResource("com/jsite/szy/dispatch/dispatchwo/data/"+path);
		if (resource.isReadable()){
			try {
				InputStream is = resource.getInputStream();
				output = objectMapper.readValue(is, WaterOptimumVOMap.class);
				logger.info("data compiled:\n"+output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return output;
	}
	
	public WaterOptimumVOMap readPath(String path){
		WaterOptimumVOMap output = null;
		Resource resource = new ClassPathResource(path);
		if (resource.isReadable()){
			try {
				InputStream is = resource.getInputStream();
				output = objectMapper.readValue(is, WaterOptimumVOMap.class);
				logger.info("data compiled:\n"+output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return output;
	}
	
	public WaterOptimumVOMap readString(String data){
		WaterOptimumVOMap output = null;
		try {			
			output = objectMapper.readValue(data, WaterOptimumVOMap.class);
			logger.info("data compiled:\n"+output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	public String write(Object object){
		String output = "";
		try {
			output = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
}
