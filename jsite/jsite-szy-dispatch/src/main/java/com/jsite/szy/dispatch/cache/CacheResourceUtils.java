package com.jsite.szy.dispatch.cache;

import java.util.List;

import com.jsite.busi.szy.emergency.po.DdsMConsec;
import com.jsite.busi.szy.emergency.po.DdsMRiver;
import com.jsite.busi.szy.emergency.service.DdsMConsecService;
import com.jsite.busi.szy.emergency.service.DdsMRiverService;
import com.jsite.busi.szy.formal.po.TSfmmEnB;
import com.jsite.busi.szy.formal.service.TSfmmEnBService;
import com.jsite.busi.szy.info.po.DdsBStat;
import com.jsite.busi.szy.info.po.DdsBWqst;
import com.jsite.busi.szy.info.service.DdsBStatService;
import com.jsite.busi.szy.info.service.DdsBWqstService;
import com.jsite.busi.szy.sys.service.DictService;
import com.jsite.core.config.Global;
import com.jsite.core.file.FileUtils;
import com.jsite.core.mapper.JsonMapper;
import com.jsite.core.spring.SpringContextHolder;
import com.jsite.core.utils.SystemPath;
import com.jsite.dao.sys.po.Dict;

public class CacheResourceUtils {
	
	private static DictService dictService = SpringContextHolder.getBean(DictService.class);
	//水文测站
	private static DdsBStatService ddsBStatService = SpringContextHolder.getBean(DdsBStatService.class);
	//应急调度 河流概化河段表
	private static DdsMRiverService ddsMRiverService = SpringContextHolder.getBean(DdsMRiverService.class);
	//模型控制断面表
	private static DdsMConsecService ddsMConsecService = SpringContextHolder.getBean(DdsMConsecService.class);
	//水质测站
	private static DdsBWqstService ddsBWqstService = SpringContextHolder.getBean(DdsBWqstService.class);
	
	//实体基本信息
	private static TSfmmEnBService tSfmmEnBService = SpringContextHolder.getBean(TSfmmEnBService.class);
	
	public static void cacheData() {
		// 字典数据
		List<Dict> dictList = dictService.list(new Dict());
		//水文测站
		List<DdsBStat> bstatList  = ddsBStatService.list(new DdsBStat());
		List<DdsMRiver> mriverlist = ddsMRiverService.list(new DdsMRiver());
		List<DdsMConsec> mconseclist = ddsMConsecService.list(new DdsMConsec());
		List<DdsBWqst> ddsBWqstlist = ddsBWqstService.list(new DdsBWqst());
		List<TSfmmEnB> tSfmmEnBlist = tSfmmEnBService.list(new TSfmmEnB());
		//做下拉框转换
		String dictJson = JsonMapper.toJsonString(dictList);
		String mriverJson = JsonMapper.toJsonString(mriverlist);	
		String mconsecJson = JsonMapper.toJsonString(mconseclist);	
		String statList = JsonMapper.toJsonString(bstatList);
		String wqstList = JsonMapper.toJsonString(ddsBWqstlist);
		String sfmmenbList = JsonMapper.toJsonString(tSfmmEnBlist);
		StringBuffer sb = new StringBuffer();
		sb.append("var dictList = " + dictJson + ";");
		sb.append("var mriverList = "+ mriverJson + ";");
		sb.append("var mconsecList = "+ mconsecJson + ";");
		sb.append(" var statList = "+statList+";");
		sb.append(" var wqstList = "+wqstList+";");
		sb.append(" var enbList = "+sfmmenbList+";"); 
		//FileUtils.writeToFile(SystemPath.getClassPath() + "http/resources/data.js", sb.toString(), false);
		FileUtils.writeToFile(Global.getConfig("uploadFile") + "http/resources/data.js", sb.toString(), false);
		
	}

}

