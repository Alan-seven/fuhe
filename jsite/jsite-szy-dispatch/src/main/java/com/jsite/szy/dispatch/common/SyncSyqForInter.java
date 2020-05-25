package com.jsite.szy.dispatch.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.jsite.busi.szy.info.po.DdsBStat;
import com.jsite.busi.szy.info.po.DdsDrPptn;
import com.jsite.busi.szy.info.po.DdsDrRiver;
import com.jsite.busi.szy.info.po.DdsDrRsvr;
import com.jsite.busi.szy.info.service.DdsBStatService;
import com.jsite.busi.szy.info.service.DdsDrPptnService;
import com.jsite.busi.szy.info.service.DdsDrRiverService;
import com.jsite.busi.szy.info.service.DdsDrRsvrService;
import com.jsite.core.config.Global;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.spring.SpringContextHolder;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.StringUtils;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;

@PersistJobDataAfterExecution  
@DisallowConcurrentExecution
public class SyncSyqForInter implements Job{
	
	private java.util.Date startTm;
	private java.util.Date endTm;
	
	public SyncSyqForInter(){
		
	}
	
	public SyncSyqForInter(Date startTm,Date endTm){
		this.startTm = startTm;
		this.endTm = endTm;
	}

	private static DdsDrPptnService ddsDrPptnService = SpringContextHolder.getBean(DdsDrPptnService.class);
	private static DdsDrRiverService ddsDrRiverService = SpringContextHolder.getBean(DdsDrRiverService.class);
	private static DdsDrRsvrService ddsDrRsvrService = SpringContextHolder.getBean(DdsDrRsvrService.class);
	private static DdsBStatService ddsBStatService = SpringContextHolder.getBean(DdsBStatService.class);
	
	private String pptnSql = " select stcd,tm,drp,intv,pdr,dyp,wth from hyits.st_pptn_r where stcd = ? and tm between ? and ? ";
	private String riverSql = " select stcd,tm,z,q from hyits.st_river_r where  stcd = ? and  tm between ? and ? ";
	private String rsvrSql = " select stcd,tm,rz,inq,w,blrz,otq,rwchrcd,rwptn,inqdr,msqmt  from hyits.st_rsvr_r where stcd = ? and  tm between ? and ? ";
	
	//同步雨量
	public void syncPptn(){
		System.out.println("开始同步雨水情");
		SourceDB sourceDB = SourceDB.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)-Integer.parseInt(Global.getConfig("syncSyqTime")));
		if(startTm==null){
			startTm = cal.getTime();
		}
		if(endTm==null){
			endTm = new java.util.Date();
		}
		try {
			List<DdsBStat> statList = ddsBStatService.list(new DdsBStat());
			for(DdsBStat entity : statList){
				//代表该站施测雨量
				if(entity.getItemP().equals("1")){
					Connection conn = sourceDB.getConnection();
					PreparedStatement queryStatement  = conn.prepareStatement(pptnSql);
					queryStatement.setString(1, entity.getStcd());
					queryStatement.setTimestamp(2, new java.sql.Timestamp(startTm.getTime()));
					queryStatement.setTimestamp(3, new java.sql.Timestamp(endTm.getTime()));
					ResultSet rss = queryStatement.executeQuery();
					//遍历结果集
					while (rss.next()) {
						DdsDrPptn vo = new DdsDrPptn();
						vo.setStcd(rss.getString(1));
						vo.setTm(rss.getTimestamp(2));
						vo.setDrp(rss.getDouble(3));
						if(rss.getDouble(4)!=0.0){
							vo.setIntv(rss.getDouble(4));
						}
						if(rss.getDouble(5)!=0.0){
							vo.setPdr(rss.getDouble(5));
						}
						if(rss.getDouble(6)!=0.0){
							vo.setAnnP(rss.getDouble(6));
						}
						if(rss.getString(7)!=null){
							vo.setWth(rss.getString(7));
						}
						System.out.println(vo.getTm());
						DdsDrPptn existPptn = ddsDrPptnService.get(vo);
						//对不存在的数据，进行保存
						if(null==existPptn){
							ddsDrPptnService.save(vo);
						}
					}
					//关闭链接
					sourceDB.close(rss,queryStatement,conn);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//logger.warn("同步雨情数据出错："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//最新河道水情
	public void syncRiver(){
		System.out.println("开始同步河道水情");
		String url = "http://10.136.4.93:8080/eai/api/service/API-RTHY-0046/executeService.rest";
		//设置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("ctlgcd", "20");
    	//设置header信息
		HttpHeaders headers = new HttpHeaders(); 
    	headers.set("Accept-Charset", "utf-8");
    	//当前登陆用户信息，用于数据过滤
    	headers.add("username", new String(Base64.encodeBase64("jxsfb".getBytes())));
    	//服务访问密钥
    	headers.add("restkeyId", "12d6096c6772466b497883a909f128c7");
    	RestTemplate restTemplate = new RestTemplate();   
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers); 
        JSONObject json =  restTemplate.postForObject(url, requestEntity, JSONObject.class);
        if(null!=json && null!=json.get("data")){
        	String[] dateFormats = new String[]{"yyyy-MM-dd HH:mm:ss"};
            JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));        
            List<RiverServiceVO> list = (List)JSONArray.toCollection(JSONArray.fromObject(json.get("data")), RiverServiceVO.class);
            DdsBStat stat = new DdsBStat();
            stat.setItemZ("1");
            List<DdsBStat> statList = ddsBStatService.list(stat);
            for(DdsBStat vo : statList){
            	for(RiverServiceVO srr : list){
            		//如果数据库中水库站码和接口站码相符
            		if(vo.getStcd().equals(srr.getStcd())){
            			DdsDrRiver ddsDrRiver = new DdsDrRiver();
            			ddsDrRiver = BeanMapper.map(srr, ddsDrRiver.getClass());
            			DdsDrRiver entity = ddsDrRiverService.get(ddsDrRiver);
            			if(null==entity){
            				ddsDrRiverService.save(ddsDrRiver);
            			}
            		}
            	}
            }
        }
        
	}
	
	//同步水库水情
	public void syncRsvr(){
		String url = "http://10.136.4.93:8080/eai/api/service/API-RTHY-0047/executeService.rest";
		//设置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("ctlgcd", "21");
    	//设置header信息
		HttpHeaders headers = new HttpHeaders(); 
    	headers.set("Accept-Charset", "utf-8");
    	//当前登陆用户信息，用于数据过滤
    	headers.add("username", new String(Base64.encodeBase64("jxsfb".getBytes())));
    	//服务访问密钥
    	headers.add("restkeyId", "12d6096c6772466b497883a909f128c7");   
        RestTemplate restTemplate = new RestTemplate();   
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers); 
        JSONObject json =  restTemplate.postForObject(url, requestEntity, JSONObject.class);
        
        String[] dateFormats = new String[]{"yyyy-MM-dd HH:mm:ss"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        if(null!=json && null!=json.get("data")){
        	 List<RsvrServiceVO> list = (List)JSONArray.toCollection(JSONArray.fromObject(json.get("data")), RsvrServiceVO.class);
             DdsBStat stat = new DdsBStat();
             stat.setItemR("1");
             List<DdsBStat> statList = ddsBStatService.list(stat);
             for(DdsBStat vo : statList){
             	for(RsvrServiceVO srr : list){
             		//如果数据库中水库站码和接口站码相符
             		if(vo.getStcd().equals(srr.getStcd())){
             			DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
             			ddsDrRsvr = BeanMapper.map(srr, ddsDrRsvr.getClass());
             			DdsDrRsvr entity = ddsDrRsvrService.get(ddsDrRsvr);
             			if(null==entity){
             				ddsDrRsvrService.save(ddsDrRsvr);
             			}
             		}
             	}
             }
        }
	}
		
	@Override
	public void execute(JobExecutionContext context)throws JobExecutionException{
		try {
			context.getJobDetail();
			// TODO Auto-generated method stub
			//syncPptn();
			syncRiver();
			syncRsvr();
		} catch (Exception e) {
		    JobExecutionException e2 = new JobExecutionException(e);
		    // true 表示立即重新执行作业
		    e2.setRefireImmediately(true);
		    throw e2;
		}
	}

	public java.util.Date getStartTm() {
		return startTm;
	}

	public void setStartTm(java.util.Date startTm) {
		this.startTm = startTm;
	}

	public java.util.Date getEndTm() {
		return endTm;
	}

	public void setEndTm(java.util.Date endTm) {
		this.endTm = endTm;
	}
	
}
