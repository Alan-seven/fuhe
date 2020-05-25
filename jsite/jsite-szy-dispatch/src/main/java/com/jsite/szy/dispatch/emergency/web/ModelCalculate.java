package com.jsite.szy.dispatch.emergency.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jsite.busi.szy.emergency.po.DdsEdBound;
import com.jsite.busi.szy.emergency.po.DdsEdEva;
import com.jsite.busi.szy.emergency.po.DdsEdEvaDet;
import com.jsite.busi.szy.emergency.po.DdsEdGis;
import com.jsite.busi.szy.emergency.po.DdsEdGisLegend;
import com.jsite.busi.szy.emergency.po.DdsEdMedel;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsEdRes;
import com.jsite.busi.szy.emergency.po.DdsEdRsv;
import com.jsite.busi.szy.emergency.po.DdsEdSource;
import com.jsite.busi.szy.emergency.po.DdsMBoundry;
import com.jsite.busi.szy.emergency.po.DdsMConsec;
import com.jsite.busi.szy.emergency.po.DdsMRsv;
import com.jsite.busi.szy.emergency.po.DdsMRsvr;
import com.jsite.busi.szy.emergency.service.DdsEdBoundService;
import com.jsite.busi.szy.emergency.service.DdsEdEvaDetService;
import com.jsite.busi.szy.emergency.service.DdsEdEvaService;
import com.jsite.busi.szy.emergency.service.DdsEdGisLegendService;
import com.jsite.busi.szy.emergency.service.DdsEdGisService;
import com.jsite.busi.szy.emergency.service.DdsEdMedelService;
import com.jsite.busi.szy.emergency.service.DdsEdPService;
import com.jsite.busi.szy.emergency.service.DdsEdResService;
import com.jsite.busi.szy.emergency.service.DdsEdRsvService;
import com.jsite.busi.szy.emergency.service.DdsEdSourceService;
import com.jsite.busi.szy.emergency.service.DdsMBoundryService;
import com.jsite.busi.szy.emergency.service.DdsMConsecService;
import com.jsite.busi.szy.emergency.service.DdsMRsvService;
import com.jsite.busi.szy.emergency.service.DdsMRsvrService;
import com.jsite.busi.szy.info.po.DdsDrRiver;
import com.jsite.busi.szy.info.po.DdsDrRsvr;
import com.jsite.busi.szy.info.service.DdsDrRiverService;
import com.jsite.busi.szy.info.service.DdsDrRsvrService;
import com.jsite.busi.szy.meeting.po.DdsSFactor;
import com.jsite.busi.szy.meeting.service.DdsSFactorService;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.mconfig.EdModelUtils;
import com.jsite.szy.dispatch.emergency.model.CalModel;
import com.jsite.szy.dispatch.emergency.model.ControlState;
import com.jsite.szy.dispatch.emergency.model.GISData;
import com.jsite.szy.dispatch.emergency.model.ModelCon;
import com.jsite.szy.dispatch.emergency.model.ModelResult;
import com.jsite.szy.dispatch.emergency.model.Reservior;
import com.jsite.szy.dispatch.emergency.vo.DdsEdPVO;
import com.jsite.szy.dispatch.emergency.vo.SecTree;

/**
 * 应急调度结果计算 Controller
 * @author hjx
 * @version 2017-07-07
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/modelcalculate")
public class ModelCalculate  extends BaseController{

	@Autowired
	private DdsEdPService ddsEdPService;
	
	public String information ="";
	
	@Autowired
	private DdsDrRiverService ddsDrRiverService;
	
	@Autowired
	private DdsDrRsvrService ddsDrRsvrService;
	
	@Autowired
	private DdsMBoundryService ddsMBoundryService;
	
	@Autowired
	private DdsMConsecService ddsMConsecService;
	
	@Autowired
	private DdsMRsvService ddsMRsvService;
	
	@Autowired
	private DdsEdBoundService ddsEdBoundService;
	
	@Autowired
	private DdsMRsvrService ddsMRsvrService;
	
	@Autowired
	private DdsEdRsvService ddsEdRsvService;
	
	@Autowired
	private DdsEdSourceService ddsEdSourceService;
	
	@Autowired
	private DdsEdMedelService ddsEdMedelService;
	
	@Autowired
	private DdsEdEvaService ddsEdEvaService;
	
	@Autowired
	private DdsEdEvaDetService ddsEdEvaDetService;
	
	@Autowired
	private DdsEdResService ddsEdResService;
	
	@Autowired
	private DdsSFactorService ddsSFacotorService;
	
	@Autowired
	private DdsEdGisService ddsEdGisService;
	
	@Autowired
	private DdsEdGisLegendService ddsEdGisLegendService;
	
	/**
	 * 调度结果
	 * @param ddsEdPVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "initresult")
	public String initResult(DdsEdPVO ddsEdPVO, HttpServletRequest request,HttpServletResponse response){
		
		ServiceResp serviceResp = new ServiceResp();
		int rcd = ddsEdPVO.getRcd();
		DdsEdP ddsEdP = ddsEdPService.get(ddsEdPVO.getProCd());
		Map<String,Object> maps = Maps.newHashMap();
		if(ddsEdPVO.getSta()!=null){//传输状态不为空，代表需要重新计算
			if("2".equals(ddsEdPVO.getStype())){
				ddsEdP.setSta(2);
			}else{
				ddsEdP.setSta(1);
			}
			//更新方案状态
			ddsEdPService.update(ddsEdP);
		}
		if(null!=ddsEdP.getSta()&& ddsEdP.getSta()>=4){//如果模型已经演算完成
			//组装断面树
			List<SecTree> secTree = new ArrayList<SecTree>();
			if("2".equals(ddsEdPVO.getStype())){
				secTree.add(new SecTree("1","水库",false,false,new ArrayList<SecTree>()));
			}
			secTree.add(new SecTree("2","测站",false,false,new ArrayList<SecTree>()));
			secTree.add(new SecTree("3","取水口",false,false,new ArrayList<SecTree>()));
			
			DdsEdRes resvo = new DdsEdRes();
			resvo.setProCd(ddsEdPVO.getProCd());
			resvo.setRcd(rcd);
			resvo.setRiver(ddsEdPVO.getRiver());
			List<DdsEdRes> edreslist = ddsEdResService.listTree(resvo);
			for(int i = 0 ; i < edreslist.size() ; i++){
				DdsEdRes ddsedres = edreslist.get(i);
				String stype = ddsedres.getStype();
				for(int j = 0 ; j < secTree.size(); j++){
					SecTree tree = secTree.get(j);
					String text = secTree.get(j).getText();
					if(text.equals(stype)){
						 List<SecTree> treeList = secTree.get(j).getChildren();
						 treeList.add(new SecTree(ddsedres.getSecId(),ddsedres.getSecnm(),true,false,new ArrayList<SecTree>()));
						 tree.setChildren(treeList);
						 tree.setExpanded(true);
						 tree.setLeaf(false);
						 break;
					}
				}
			}
			DdsEdEva ddsEdEva = new DdsEdEva();
			ddsEdEva.setProCd(ddsEdPVO.getProCd());
			List<DdsEdEva> listeva = ddsEdEvaService.list(ddsEdEva);
			maps.put("listeva", listeva);
			maps.put("secTree", secTree);
		}else{//模型未演算完成
        	String evenCd = ddsEdP.getEvenCd();

			//污染源信息表
			DdsEdSource ddsEdSource = ddsEdSourceService.get(evenCd);
			double DA = ddsEdSource.getDa();
			int da_type = ddsEdSource.getDaType();
			
			DdsMConsec upconsec = ddsMConsecService.get(ddsEdSource.getUpsec());
			double lenUp = ddsEdSource.getLenUp();
			lenUp = lenUp+upconsec.getLenup();
			//方案基本信息表
			int foreTime=ddsEdP.getForTime();//前沿时段：小时 ——数据库加
			//Date startTime;// 计算起始时间， 污染发生时间 >= startTime - foreTime
			Date bgdt = ddsEdP.getBgDt();
			Date eddt = ddsEdP.getEdDt();
			Date tm = ddsEdSource.getTm();
			int deltaT=1;//输入序列的时间间隔：1h
			long l = (eddt.getTime()-bgdt.getTime())/(60*60*1000);
			int length=  new Long(l).intValue();//计算总时段数，单位：h
			long ll = (tm.getTime()-bgdt.getTime())/(60*60*1000);
			
			 DdsEdBound dsb = new DdsEdBound();
			 dsb.setProCd(ddsEdPVO.getProCd());
			 dsb.setStartTime(DateUtils.formatDateTime(bgdt));
			 dsb.setEndTime(DateUtils.formatDateTime(eddt));
			 List<DdsEdBound> boundlist = ddsEdBoundService.list(dsb);
			 DdsMBoundry ddsMBoundry = new DdsMBoundry();
			 ddsMBoundry.setRcd(rcd);
			 List<DdsMBoundry> listBoundry = ddsMBoundryService.list(ddsMBoundry);
			 DdsMConsec ddsMConsec = new DdsMConsec();
			 ddsMConsec.setRcd(rcd);
			 List<DdsMConsec> listmconsec = ddsMConsecService.list(ddsMConsec);
			 List<DdsMConsec> consecData = Lists.newArrayList();//去掉水库断面
			
			 for(int i = 0 ; i < listmconsec.size() ; i++){
				 if(!listmconsec.get(i).getSecnm().contains("水库")){
					 consecData.add(listmconsec.get(i));
				 }
			 }
			 double[] WQgoal= new double[consecData.size()];
			 for(int i = 0 ; i < consecData.size();i++){
				 WQgoal[i] = 0.01;
			 }
			 
			int tot = length*listBoundry.size();
			 if(tot>boundlist.size()){
					serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
					serviceResp.setMsg("边界条件导入的数据条数不可小于"+tot+"条记录");
					logger.warn("边界条件导入的数据条数不可小于"+tot+"条记录");
					return renderString(response, serviceResp);
			}
			 for(DdsEdBound entity : boundlist){
				 if( entity.getQ() == null && entity.getZ() ==null && entity.getInq()==null){
						serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
						serviceResp.setMsg("请设置边界条件的监测数据值");
						logger.warn("请设置边界条件的监测数据值");
						return renderString(response, serviceResp);
					}
			}
			 DdsMRsv ddsMRsv = new DdsMRsv();
			 ddsMRsv.setRcd(rcd);
			 ddsMRsv.setRiver(ddsEdPVO.getRiver());
			 List<DdsMRsv> listrsv = ddsMRsvService.list(ddsMRsv);
			
			DdsEdRsv edrsv = new DdsEdRsv();
			edrsv.setProCd(ddsEdPVO.getProCd());
			edrsv.setStartTm(DateUtils.formatDateTime(bgdt));
			edrsv.setEndTm(DateUtils.formatDateTime(eddt));
			List<DdsEdRsv> edrsvlist = ddsEdRsvService.list(edrsv);
			
			int total = length*listrsv.size();
			if(total>edrsvlist.size()&&"2".equals(ddsEdPVO.getStype())){
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg("水库调节导入的数据条数不可小于"+total+"条记录");
				logger.warn("水库调节导入的数据条数不可小于"+total+"条记录");
				return renderString(response, serviceResp);
			}
			if("2".equals(ddsEdPVO.getStype())){
				for(DdsEdRsv entity : edrsvlist){
					if(entity.getOtq()==null ){
						serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
						serviceResp.setMsg("请设置水库的下泄流量");
						logger.warn("请设置水库的下泄流量");
						return renderString(response, serviceResp);
					}
					if( entity.getExq() == null){
						serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
						serviceResp.setMsg("请设置水库的加大下泄量");
						logger.warn("请设置水库的加大下泄量");
						return renderString(response, serviceResp);
					}
				}
			}
			
			if("2".equals(ddsEdPVO.getStype())){
				ddsEdP.setSta(3);
			}else{
				ddsEdP.setSta(2);
			}
			//更新方案状态为3
			ddsEdPService.update(ddsEdP);
			
			int accurTime = new Long(ll).intValue();//污染发生时间 距离 计算起始时间的时段数 (TM-startTime)/deltaT
			double durTime= ddsEdSource.getDur(); // 污染物持续时段数 DUR/deltaT
			
			/**
			 * 方案模型参数信息——加
			 */
			DdsEdMedel medel = ddsEdMedelService.get(ddsEdP.getProCd());
			double r = 0.0;
			double a = 0.0;
			double k = 0.0;
			if(null!= medel&&null!=medel.getR()){
				r = medel.getR();
			}// 按控制断面区间给
			if(null!= medel&&null!=medel.getA()){
				a = medel.getA();
			}// 扩散系数
			if(null!= medel&&null!=medel.getK()){
				k = medel.getK();
			}// 衰减系数
			
			/**
			 * 初始条件信息
			 */
			double BG_CO= ddsEdP.getBgco();
			 double[] BG_Z=null;//水库初始水位（水库运行方式界面）
			//得到水库调节设置初始条件
			 DdsMRsvr ddsMRsvr = new DdsMRsvr();
			 ddsMRsvr.setProCd(ddsEdPVO.getProCd());
			 List<DdsMRsvr> listrsvr = ddsMRsvrService.list(ddsMRsvr);
			 BG_Z =  new double[listrsvr.size()];
			 for(int i = 0 ; i <listrsvr.size();i++ ){
				 if(null!=listrsvr.get(i).getZ()){
					 BG_Z[i] = listrsvr.get(i).getZ();
				 }else{
					 serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
					 serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG+",请设置水库初始水位，初始流量！");
					 logger.warn(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG+",请设置水库初始水位，初始流量！");
					 return  renderString(response,serviceResp);
				 }
			 }
			 
			 double BG_CONC=0; // 水库初始污染物浓度（新建方案界面）-暂时没用
			 double[] BG_Q={0,0};// 测站初始流量（新建方案界面）-暂时没用
			 
			 //方案边界条件信息表 
			 double[][]boundry = new double[listBoundry.size()][foreTime+length+1]; //根据模型配置的顺序，每一个边界存一个数组-界面传
			 Calendar forTimeCal = Calendar.getInstance();
			 forTimeCal.setTime(bgdt);
			 forTimeCal.add(Calendar.HOUR, -foreTime);
			 boundry = getBoundry(boundry,bgdt, eddt ,forTimeCal,foreTime,listBoundry,ddsEdP);
					 
			 //水库调节信息表
			 double[][]outflow= null ;
			 double[][]deltaflow= null ;
			 if("2".equals(ddsEdPVO.getStype())){
				 outflow = new double[listrsv.size()][foreTime+length+1]; //原计划
				 deltaflow = new double[listrsv.size()][foreTime+length+1]; //加大量
				 Map<String,double[][]> flow = getFlow(listrsv ,forTimeCal, bgdt, eddt,  foreTime, ddsEdP, length, outflow,deltaflow);
				 outflow = flow.get("outflow");
				 deltaflow = flow.get("deltaflow");
			 }
			
			 //输入计算模型需要数据
			 ModelCon conditions=new ModelCon();
			 conditions.setPRO_CD(ddsEdP.getProCd());
			 conditions.setRCD(rcd);
			 conditions.setDA(DA);
			 conditions.setDA_TYPE(da_type); 
			 conditions.setLEN_UP(lenUp);
			 conditions.setDeltaT(deltaT);
			 conditions.setForeTime(foreTime);
			 conditions.setAccurTime(accurTime);
			 conditions.setDurTime(new Double(durTime).intValue());
			 conditions.setLength(length); 
			 conditions.setA(a);
			 conditions.setR(r);
			 conditions.setK(k);
			 conditions.setBG_CO(BG_CO);
	         conditions.setBG_Q(BG_Q);
	         conditions.setWQgoal(WQgoal); 
	         conditions.setBoundry(boundry);
			// conditions.setBG_CONC(BG_CONC);
			 if("2".equals(ddsEdPVO.getStype())){//水质模拟时不需要输入
				 conditions.setBG_Z(BG_Z);
				 conditions.setOutflow(outflow);
				 conditions.setDeltaflow(deltaflow);
			 }
			 
			 ModelResult mResult = new ModelResult();
			 CalModel calmodel=new CalModel();
			 Reservior[] reserviors=null;
			 ControlState states[]=null;
			 
			try {
				mResult = calmodel.startModel(conditions,reserviors,states);
			} catch (Exception e) {
				logger.warn("方案名称："+ddsEdP.getProNm()+"模型计算出错!");
				e.printStackTrace();
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg("方案名称："+ddsEdP.getProNm()+"模型计算出错!");
				return renderString(response, serviceResp);
			}
			 //清楚所有方案计算结果数据
			 DdsEdRes res = new DdsEdRes();
			 res.setProCd(ddsEdPVO.getProCd());
			 ddsEdResService.removeAll(res);
			//组装断面树
			List<Date> listDate = EdModelUtils.getDateBetweenTwoDate(forTimeCal.getTime(), eddt);
		
			serviceResp = saveState(foreTime,listDate,mResult,ddsEdPVO);
			if(serviceResp.getCode()==0){
				return renderString(response,serviceResp);
			}
			serviceResp = saveEdEva(mResult,ddsEdPVO);
			if("2".equals(ddsEdPVO.getStype())){
				serviceResp = saveReservior(listDate,mResult,ddsEdPVO);
				if(serviceResp.getCode()==0){
					return renderString(response,serviceResp);
				}
				ddsEdP.setSta(4);
			}else{
				ddsEdP.setSta(3);
			}
			//更新方案状态为4
			ddsEdPService.update(ddsEdP);
			serviceResp = saveEdGis(mResult, ddsEdPVO);
			DdsEdGisLegend gisLegend = new DdsEdGisLegend();
			gisLegend.setProCd(ddsEdPVO.getProCd());
			ddsEdGisLegendService.remove(gisLegend);
			gisLegend.setGmax(mResult.getLegend().getMax());
			gisLegend.setGmin(mResult.getLegend().getMin());
			ddsEdGisLegendService.save(gisLegend);
			if(serviceResp.getCode()==0){
				return renderString(response,serviceResp);
			}
			if("2".equals(ddsEdPVO.getStype())){
				ddsEdP.setSta(5);
			}else{
				ddsEdP.setSta(4);
			}
			//更新方案状态
			ddsEdPService.update(ddsEdP);
			//得到评价数据
			DdsEdEva ddsEdEva = new DdsEdEva();
			ddsEdEva.setProCd(ddsEdPVO.getProCd());
			List<DdsEdEva> listeva = ddsEdEvaService.list(ddsEdEva);
			maps.put("listeva", listeva);
			
			//组装断面树
			List<SecTree> secTree = new ArrayList<SecTree>();
			if("2".equals(ddsEdPVO.getStype())){
				secTree.add(new SecTree("1","水库",false,false,new ArrayList<SecTree>()));
			}
			secTree.add(new SecTree("2","测站",false,false,new ArrayList<SecTree>()));
			secTree.add(new SecTree("3","取水口",false,false,new ArrayList<SecTree>()));
			
			DdsEdRes resvo = new DdsEdRes();
			resvo.setProCd(ddsEdPVO.getProCd());
			resvo.setRcd(rcd);
			resvo.setRiver(ddsEdPVO.getRiver());
			List<DdsEdRes> edreslist = ddsEdResService.listTree(resvo);
			for(int i = 0 ; i < edreslist.size() ; i++){
				DdsEdRes ddsedres = edreslist.get(i);
				String stype = ddsedres.getStype();
				for(int j = 0 ; j < secTree.size(); j++){
					SecTree tree = secTree.get(j);
					String text = secTree.get(j).getText();
					if(text.equals(stype)){
						 List<SecTree> treeList = secTree.get(j).getChildren();
						 treeList.add(new SecTree(ddsedres.getSecId(),ddsedres.getSecnm(),true,false,new ArrayList<SecTree>()));
						 tree.setChildren(treeList);
						 tree.setExpanded(true);
						 tree.setLeaf(false);
						 break;
					}
				}
			}
			maps.put("serviceResp", serviceResp);
			maps.put("secTree", secTree);
		}
		return renderString(response,maps);
	}
	
	/**
	 * 得到水库下泄流量数据
	 * @param listrsv 得到参与调度的水库
	 * @param forTimeCal	
	 * @param bgdt 方案开始时间
	 * @param eddt	方案结束时间
	 * @param foreTime 预热期
	 * @param ddsEdP	方案信息
	 * @param length	
	 * @param outflow  
	 * @param deltaflow
	 * @return
	 */
	public Map<String,double[][]> getFlow(List<DdsMRsv> listrsv ,Calendar forTimeCal,Date bgdt,Date eddt, int foreTime,DdsEdP ddsEdP,int length, double[][]outflow,double[][]deltaflow){
		Map<String,double[][]> map = Maps.newHashMap();
		//根据方案编码查询方案对应的下泄流量情况
		 for(int i = 0 ; i < listrsv.size(); i++ ){
			 DdsMRsv mRsv = listrsv.get(i);
			 DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
			 ddsDrRsvr.setStcd(mRsv.getStcd());
			 ddsDrRsvr.setStartTm(DateUtils.formatDateTime(forTimeCal.getTime()));
			 ddsDrRsvr.setEndTm(DateUtils.formatDateTime(bgdt));
			 List<DdsDrRsvr> listDrRsvr = ddsDrRsvrService.listByStcd(ddsDrRsvr);
			//插值处理
			List<Date> listDate = EdModelUtils.getDateBetweenTwoDate(forTimeCal.getTime(), bgdt);
			listDrRsvr = EdModelUtils.getFullDrRsvr(listDate, listDrRsvr);
			listDrRsvr = EdModelUtils.getListRsvrByIn(listDrRsvr);
			for(int j = 0; j < foreTime; j++){
				if(foreTime <= listDrRsvr.size()){
						double otq = listDrRsvr.get(j).getOtq()==null?0.0:listDrRsvr.get(j).getOtq();
						outflow[i][j] = otq;
						deltaflow[i][j] = 0;
				}else{
					 outflow[i][j] = 0;
					 deltaflow[i][j] = 0;
				}
			}
		 }
		// 模拟期输入从界面设置获取
		 double planOtq=0.0;
		 double realOut =0.0;
		 for(int x = 0 ; x < listrsv.size(); x++){
			 DdsMRsv mRsv = listrsv.get(x);
			 DdsEdRsv ddsEdRsv = new DdsEdRsv();
			 ddsEdRsv.setProCd(ddsEdP.getProCd());
			 ddsEdRsv.setStcd(mRsv.getStcd());
			 ddsEdRsv.setStartTm(DateUtils.formatDate(bgdt, "yyyy-MM-dd HH:mm:ss"));
			 ddsEdRsv.setEndTm(DateUtils.formatDate(eddt, "yyyy-MM-dd HH:mm:ss"));
			 List<DdsEdRsv> listEdRsv = ddsEdRsvService.list(ddsEdRsv);
				 for(int j = 0 ; j < listEdRsv.size() ; j++){
					 DdsEdRsv rsv = listEdRsv.get(j);
					 double otq = rsv.getOtq()!=null?rsv.getOtq():0;
					 double exq = rsv.getExq()!=null?rsv.getExq():0;
					 if(j<length+1){
						 outflow[x][j+foreTime] = otq;
						 deltaflow[x][j+foreTime] = exq;
					 }
					 if(planOtq==0.0 && otq!=0){
						 planOtq = otq;
					 }
					 if(realOut==0.0 && exq!=0){
						 realOut = exq;
					 }
				 }	
				 //判断预热期水库数据不为0
				 for(int j = 0; j < foreTime; j++){
					 if(outflow[x][j]==0.0){
						 outflow[x][j] = planOtq;
					 }
					 if(deltaflow[x][j]==0.0){
						 deltaflow[x][j] = realOut;
					 }
				}
				 planOtq= 0.0;
				 realOut =0.0;
		 }
		 map.put("outflow", outflow);
		 map.put("deltaflow", deltaflow);
		 return map;
	}
	
	//保存评价结果
	public ServiceResp saveEdEva(ModelResult mResult,DdsEdPVO ddsEdPVO){
		 ServiceResp ServiceResp = new ServiceResp();
		 DdsSFactor ddsSFactor= new DdsSFactor();
		 ddsSFactor.setFactTp("3");
		 List<DdsSFactor> list = ddsSFacotorService.list(ddsSFactor);
		 if(list.size()>0){
			 DdsEdEva ddsEdEva = new DdsEdEva();
			 ddsEdEva.setProCd(ddsEdPVO.getProCd());
			 ServiceResp = ddsEdEvaService.remove(ddsEdEva); 
		 }
		 for(DdsSFactor vo : list){
			 DdsEdEva ddsEdEva = new DdsEdEva();
			 ddsEdEva.setProCd(ddsEdPVO.getProCd());
			 ddsEdEva.setFactId(vo.getFactId());
			 if(vo.getFactNm().contains("取水口")){
				 ddsEdEva.setValue(Double.valueOf(mResult.getIntakeNUM()));
			 }else if(vo.getFactNm().contains("时长")){
				 ddsEdEva.setValue(mResult.getInterTM());
			 }else if(vo.getFactNm().contains("耗水量")){
				 ddsEdEva.setValue(mResult.getDeltaWA());
			 }else if(vo.getFactNm().contains("损失")){
				 ddsEdEva.setValue(mResult.getDeltaHA());
			 }
			 ServiceResp = ddsEdEvaService.save(ddsEdEva); 
		}
		 return ServiceResp;
	}
		
		/**
		 * 组装计算模型需要的边界条件输入参数
		 * @param boundry
		 * @param bgdt
		 * @param eddt
		 * @param foreTime
		 * @param listBoundry
		 * @param ddsEdP
		 * @return
		 */
		public double[][] getBoundry(double[][] boundry,Date bgdt,Date eddt ,Calendar forTimeCal,int foreTime,List<DdsMBoundry> listBoundry,DdsEdP ddsEdP ){
			 double q = 0.0;
			 double z = 0.0;
			 double inq = 0.0;
			 for(int i = 0 ; i < listBoundry.size();i++){
				 DdsMBoundry vo = listBoundry.get(i);
				 String fieldNm = vo.getFieldnm();
				//流量，水位
				 if("Q".equals(fieldNm)||"Z".equals(fieldNm)){
					 	DdsDrRiver ddsDrRiver = new DdsDrRiver();
						ddsDrRiver.setStcd(vo.getStcd());
						ddsDrRiver.setStartTime(DateUtils.formatDateTime(forTimeCal.getTime()));
						ddsDrRiver.setEndTime(DateUtils.formatDateTime(bgdt));
						List<DdsDrRiver> listriver = ddsDrRiverService.listByStcd(ddsDrRiver);
						//插值处理
						List<Date> listDate = EdModelUtils.getDateBetweenTwoDate(forTimeCal.getTime(), bgdt);
						listriver = EdModelUtils.getFullDrRiver(listDate, listriver);
						listriver = EdModelUtils.getListRiverByIn(listriver);
						for(int j = 0; j < foreTime; j++){
							if("Q".equals(fieldNm) && foreTime <= listriver.size()){
								q = listriver.get(j).getQ()!=null?listriver.get(j).getQ():0.0;
								boundry[i][j]= q ;
							}else if("Z".equals(fieldNm) && foreTime <=listriver.size() ){
								z = listriver.get(j).getZ()!=null?listriver.get(j).getZ():0.0;
								boundry[i][j]= z ;
							}
							z = 0.0;
							q = 0.0;
						}
				 }else if("INQ".equals(fieldNm)){//入库流量
						DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
						ddsDrRsvr.setStcd(vo.getStcd());
						ddsDrRsvr.setStartTm(DateUtils.formatDateTime(forTimeCal.getTime()));
						ddsDrRsvr.setEndTm(DateUtils.formatDateTime(bgdt));
						List<DdsDrRsvr> listDrRsvr = ddsDrRsvrService.listByStcd(ddsDrRsvr);
						//插值处理
						List<Date> listDate = EdModelUtils.getDateBetweenTwoDate(forTimeCal.getTime(), bgdt);
						listDrRsvr = EdModelUtils.getFullDrRsvr(listDate, listDrRsvr);
						listDrRsvr = EdModelUtils.getListRsvrByIn(listDrRsvr);
						for(int j = 0; j < foreTime; j++){
							 if("INQ".equals(fieldNm) && foreTime <= listDrRsvr.size()){
								 inq = listDrRsvr.get(j).getInq()!=null?listDrRsvr.get(j).getInq():0.0;
								 boundry[i][j]= inq ;
							}
							inq = 0.0;
						}
				 }
				 q = 0.0;
				 z = 0.0;
				 inq = 0.0; 
			 }
			 
			// 模拟期输入从界面设置获取
			 for(int x = 0 ; x < listBoundry.size(); x++){
				 DdsMBoundry vo = listBoundry.get(x);
				 String fieldNm = vo.getFieldnm();
				 DdsEdBound ddsEdBound = new DdsEdBound();
				 ddsEdBound.setProCd(ddsEdP.getProCd());
				 ddsEdBound.setStcd(vo.getStcd());
				 ddsEdBound.setStartTime(DateUtils.formatDate(bgdt, "yyyy-MM-dd HH:mm:ss"));
				 ddsEdBound.setEndTime(DateUtils.formatDate(eddt, "yyyy-MM-dd HH:mm:ss"));
				 List<DdsEdBound> listbound = ddsEdBoundService.list(ddsEdBound);
					 double initq = 0.0;
					 double initz = 0.0;
					 double initinq = 0.0;
					for(int j = 0 ; j < listbound.size();j++){
						if("Q".equals(fieldNm)){
							q = listbound.get(j).getQ()!=null?listbound.get(j).getQ():0.0;
							boundry[x][j+foreTime]= q ;
						}else if("Z".equals(fieldNm)){
							z = listbound.get(j).getZ()!=null?listbound.get(j).getZ():0.0;
							boundry[x][j+foreTime] = z ;
						}else if("INQ".equals(fieldNm)){
							inq = listbound.get(j).getInq()!=null?listbound.get(j).getInq():0.0;
							boundry[x][j+foreTime] = inq ;
						}
						 if(initq==0.0 && q!=0){
							 initq = q;
						 }
						 if(initz==0.0 && z!=0){
							 initz = z;
						 }
						 if(initinq==0.0 && inq!=0){
							 initinq = inq;
						 }
					}
					 //判断预热期水库数据如果为0，就赋值
					 for(int j = 0; j < foreTime; j++){
						 if(boundry[x][j]==0.0){
							 if("Q".equals(fieldNm)){
								boundry[x][j]= initq ;
							}else if("Z".equals(fieldNm)){
								boundry[x][j] = initz ;
							}else if("INQ".equals(fieldNm)){
								boundry[x][j] = initinq ;
							}
						 }
					}
			 }
			return boundry;
		}
		
		/**
		 * 保存第四步模型计算出的水库数据
		 * @param listDate
		 * @param mResult
		 * @param ddsEdPVO
		 * @return
		 */
		public ServiceResp saveReservior(List<Date> listDate ,ModelResult mResult,DdsEdPVO ddsEdPVO){
			ServiceResp serviceResp = new ServiceResp();
			try{
		     serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			//save 模型计算后的值
			 Reservior[] reserviors = mResult.getReserviors();
			 if(null != reserviors){
				 serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
				 for(int i = 0 ; i < reserviors.length;i++){
					 String stateCD = reserviors[i].getStateCD();
					 double[] planQin =  reserviors[i].getPlanQin();
					 double[] planQout =  reserviors[i].getPlanQout();
					 double[] planLevel =  reserviors[i].getPlanLevel();
					 
					 double[] realQin =  reserviors[i].getRealQin();
					 
					 double[] realQout =  reserviors[i].getRealQout();
					 double[] realLevel =  reserviors[i].getRealLevel();
					 
					 List<DdsEdRes> planList = Lists.newArrayList();
					 //原计划值
					 if(null!=planQin){
						 for(int j = 0 ; j <planQin.length ;j++){
							 DdsEdRes entity = new DdsEdRes();
							 entity.setProCd(ddsEdPVO.getProCd());
							 entity.setqType("0");
							 entity.setTm(listDate.get(j));
							 entity.setSecId(stateCD);
							 entity.setInq(planQin[j]);
							 entity.setOtq(planQout[j]);
							 entity.setZ(planLevel[j]);
							 planList.add(entity);
							 //serviceResp =  ddsEdResService.save(entity);
						 }
						 serviceResp = ddsEdResService.insertBatch(planList);
						 if(serviceResp.getCode()==0){
								return serviceResp;
						 }
					 }
					 //调整后的值
					 List<DdsEdRes> realList = Lists.newArrayList();
					 if(null!=realQin){
						 for(int j = 0 ; j <realQin.length ;j++){
							 DdsEdRes entity = new DdsEdRes();
							 entity.setProCd(ddsEdPVO.getProCd());
							 entity.setqType("1");
							 entity.setTm(listDate.get(j));
							 entity.setSecId(stateCD);
							 entity.setInq(realQin[j]);
							 entity.setOtq(realQout[j]);
							 entity.setZ(realLevel[j]);
							 realList.add(entity);
							 //serviceResp =  ddsEdResService.save(entity);
						 }
						 serviceResp = ddsEdResService.insertBatch(realList);
						 if(serviceResp.getCode()==0){
								return serviceResp;
						 }
					 }
				 }
			 }
			}catch(Exception e){
				logger.warn("存水库模型计算结果数据出错内容："+e.getMessage());
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG+",保存水库模型计算结果数据出错");
				logger.warn("保存水库模型计算结果数据出错");
			}
			return serviceResp;
		}
		
		/**
		 * 保存第四步模型计算出的断面数据
		 * @param listDate
		 * @param mResult
		 * @param ddsEdPVO
		 * @return
		 */
		public ServiceResp saveState(int foreTime,List<Date> listDate ,ModelResult mResult,DdsEdPVO ddsEdPVO){
			ServiceResp serviceResp = new ServiceResp();
			try{//只保存  计算中的页面展示数据
				List<ControlState> listState = mResult.getListSEC();
				if(null != listState){
					 serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
					 for(int i = 0 ; i < listState.size();i++){
						 ControlState state = listState.get(i);
						 
						 String StateID = state.getStateID();
						// int infuenceTime = state.getInfuenceTime();
						 double[] outFlow = state.getOutFlow();
						 double[] Level = state.getLevel();
						 double[] concentration = state.getConcentration();
						 //int realinfTime = state.getRealinfTime();
						 double[] realFlow = state.getRealFlow();
						 double[] realLevel = state.getRealLevel();
						 double[] realconcen = state.getRealconcen();
						 
						 String StateType = state.getStateType();
						 DdsEdEvaDet ddsEdEvaDet = new DdsEdEvaDet();
						 ddsEdEvaDet.setProCd(ddsEdPVO.getProCd());
						 ddsEdEvaDet.setSecId(StateID);
						 if("0".equals(StateType)){//0代表水库  ，存储水头损失
							 ddsEdEvaDet.setSecValue(mResult.getDeltaHA());
						 }else{//其他类型存储时长
							 ddsEdEvaDet.setSecValue(mResult.getInterTM());
						 }
						 serviceResp = ddsEdEvaDetService.save(ddsEdEvaDet);
						
						 //原计划值
						 List<DdsEdRes> planList = Lists.newArrayList();
						 if(null!=outFlow){
							 for(int j = 0 ; j <outFlow.length ;j++){
								 DdsEdRes entity = new DdsEdRes();
								 entity.setProCd(ddsEdPVO.getProCd());
								 entity.setTm(listDate.get(j+foreTime));
								 entity.setqType("0");
								 entity.setSecId(StateID);
								 entity.setQ(outFlow[j]);
								 entity.setZ(Level[j]);
								 BigDecimal  b  =   new   BigDecimal(concentration[j]);  
								 double  f1  =  b.setScale(5,   BigDecimal.ROUND_HALF_UP).doubleValue();
								 entity.setBoPl(f1);
								 planList.add(entity);
								 //serviceResp =  ddsEdResService.save(entity);
							 }
							 serviceResp =  ddsEdResService.insertBatch(planList);
							 if(serviceResp.getCode()==0){
								 return serviceResp;
							 }
						 }
						 
						//调整后的值
						 List<DdsEdRes> realList = Lists.newArrayList();
						 if(null!=realFlow){
							 for(int j = 0 ; j <realFlow.length ;j++){
								 DdsEdRes entity = new DdsEdRes();
								 entity.setProCd(ddsEdPVO.getProCd());
								 entity.setqType("1");
								 entity.setTm(listDate.get(j+foreTime));
								 entity.setSecId(StateID);
								 entity.setQ(realFlow[j]);
								 entity.setZ(realLevel[j]);
								 BigDecimal  b  =   new   BigDecimal(realconcen[j]);  
								 double  f1  =  b.setScale(5,   BigDecimal.ROUND_HALF_UP).doubleValue();
								 entity.setBoPl(f1);
								 realList.add(entity);
								 //serviceResp =  ddsEdResService.save(entity);
							 }
							 serviceResp= ddsEdResService.insertBatch(realList);
							 if(serviceResp.getCode()==0){
								 return serviceResp;
							 }
						 }
					 }
				} 
			}catch(Exception e){
				logger.warn("存河道模型计算结果数据出错内容："+e.getMessage());
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG+",保存河道模型计算结果数据出错");
			}
			return serviceResp;
		}
		
		/**
		 * 保存地图数据
		 * @param mResult
		 * @param ddsEdPVO
		 * @return
		 */
		public ServiceResp saveEdGis(ModelResult mResult,DdsEdPVO ddsEdPVO){
			ServiceResp serviceResp = new ServiceResp();
			List<GISData> gislist = mResult.getListGIS();
			try{
				if(null!=gislist){
					serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
					DdsEdGis gisData = new DdsEdGis();
					gisData.setProCd(ddsEdPVO.getProCd());
					ddsEdGisService.removeAll(gisData);
					List<DdsEdGis> listData = Lists.newArrayList();
					for(int i = 0 ; i < gislist.size(); i++){
						DdsEdGis gis = new DdsEdGis();
						gis.setProCd(ddsEdPVO.getProCd());
						gis.setRcd(ddsEdPVO.getRcd());
						if(StringUtils.isNotBlank(gislist.get(i).getTime())){
							int time = Integer.parseInt(gislist.get(i).getTime());
							gis.setTime(time);
						}
						gis.setFid(gislist.get(i).getFid());
						gis.setPlanValue(gislist.get(i).getPlanValue());
						gis.setRealValue(gislist.get(i).getRealValue());
						listData.add(gis);
					}
					serviceResp = ddsEdGisService.insertBatch(listData);
				}
			}catch(Exception e){
				logger.warn("保存河道模型GIS计算结果出错内容："+e.getMessage());
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG+",保存河道模型GIS计算结果数据出错");
			}
			return serviceResp;
		}
		
}