package com.jsite.szy.dispatch.common;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
 
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jsite.busi.szy.info.po.DdsBStat;
import com.jsite.busi.szy.info.po.DdsDrPptn;
import com.jsite.busi.szy.info.po.DdsDrRiver;
import com.jsite.busi.szy.info.po.DdsDrRsvr;
import com.jsite.busi.szy.info.service.DdsBStatService;
import com.jsite.busi.szy.info.service.DdsDrPptnService;
import com.jsite.busi.szy.info.service.DdsDrRiverService;
import com.jsite.busi.szy.info.service.DdsDrRsvrService;
import com.jsite.core.config.Global;
import com.jsite.core.spring.SpringContextHolder;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.StringUtils;
 
//@Component
//@Lazy(false)
//@PersistJobDataAfterExecution  
//@DisallowConcurrentExecution
public class SyncSyq{
    
    private java.util.Date startTm;
    private java.util.Date endTm;
    
    public SyncSyq(){
        
    }
    
    public SyncSyq(Date startTm,Date endTm){
        this.startTm = startTm;
        this.endTm = endTm;
    }
 
    @Autowired
    private DdsDrPptnService ddsDrPptnService;
    @Autowired
    private DdsDrRiverService ddsDrRiverService;
    @Autowired
    private DdsDrRsvrService ddsDrRsvrService;
    @Autowired
    private DdsBStatService ddsBStatService;
    
    //private static DdsDrPptnService ddsDrPptnService = SpringContextHolder.getBean(DdsDrPptnService.class);
   // private static DdsDrRiverService ddsDrRiverService = SpringContextHolder.getBean(DdsDrRiverService.class);
   // private static DdsDrRsvrService ddsDrRsvrService = SpringContextHolder.getBean(DdsDrRsvrService.class);
    //private static DdsBStatService ddsBStatService = SpringContextHolder.getBean(DdsBStatService.class);
    
    private String pptnSql = " select stcd,tm,drp,intv,pdr,dyp,wth from hyits.st_pptn_r where stcd = ? and tm between ? and ? ";
    private String riverSql = " select stcd,tm,z,q from hyits.st_river_r where  stcd = ? and  tm between ? and ? ";
    private String rsvrSql = " select stcd,tm,rz,inq,w,blrz,otq,rwchrcd,rwptn,inqdr,msqmt  from hyits.st_rsvr_r where stcd = ? and  tm between ? and ? ";
    
    //同步雨量
    @Async
    @Scheduled(cron = "0 2 0/1 * * ?")
    //@Scheduled(cron = "0 0/2 0/1 * * ?")
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
    
    //同步雨量
    @Async
    @Scheduled(cron = "0 3 0/1 * * ?")
    public void syncRiver(){
        System.out.println("开始同步河道水情");
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
                //代表该站施测水位流量
                if(entity.getItemZ().equals("1")){
                    Connection conn = sourceDB.getConnection();
                    PreparedStatement queryStatement  = conn.prepareStatement(riverSql);
                    queryStatement.setString(1, entity.getStcd());
                    queryStatement.setTimestamp(2, new java.sql.Timestamp(startTm.getTime()));
                    queryStatement.setTimestamp(3, new java.sql.Timestamp(endTm.getTime()));
                    ResultSet rss = queryStatement.executeQuery();
                    //遍历结果集
                    while (rss.next()) {
                        DdsDrRiver vo = new DdsDrRiver();
                        vo.setStcd(rss.getString(1));
                        vo.setTm(rss.getTimestamp(2));
                        if(rss.getDouble(3)!=0.0){
                            vo.setZ(rss.getDouble(3));
                        }
                        if(rss.getDouble(4)!=0.0){
                            vo.setQ(rss.getDouble(4));
                        }
                        System.out.println(vo.getTm());
                        DdsDrRiver existRiver = ddsDrRiverService.get(vo);
                        //对不存在的数据，进行保存
                        if(null==existRiver){
                            ddsDrRiverService.save(vo);
                        }
                    }
                    //关闭链接
                    sourceDB.close(rss,queryStatement,conn);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //logger.warn("同步河道水情数据出错："+e.getMessage());
            e.printStackTrace();
        }
    }
    
    //同步水库水情
    @Async
    @Scheduled(cron = "0 5 0/1 * * ?")
    public void syncRsvr(){
        System.out.println("开始同步水库水情");
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
                //代表该站施测水库
                if(entity.getItemR().equals("1")){
                    Connection conn = sourceDB.getConnection();
                    PreparedStatement queryStatement  = conn.prepareStatement(rsvrSql);
                    queryStatement.setString(1, entity.getStcd());
                    queryStatement.setTimestamp(2, new java.sql.Timestamp(startTm.getTime()));
                    queryStatement.setTimestamp(3, new java.sql.Timestamp(endTm.getTime()));
                    ResultSet rss = queryStatement.executeQuery();
                    //遍历结果集
                    while (rss.next()) {
                        DdsDrRsvr vo = new DdsDrRsvr();
                        vo.setStcd(rss.getString(1));
                        vo.setTm(rss.getTimestamp(2));
                        if(rss.getDouble(3)!=0.0){
                            vo.setRz(rss.getDouble(3));
                        }
                        if(rss.getDouble(4)!=0.0){
                            vo.setInq(rss.getDouble(4));
                        }
                        if(rss.getDouble(5)!=0.0){
                            vo.setW(rss.getDouble(5));
                        }
                        if(rss.getDouble(6)!=0.0){
                            vo.setBlrz(rss.getDouble(6));
                        }
                        if(rss.getDouble(7)!=0.0){
                            vo.setOtq(rss.getDouble(7));
                        }
                        if(rss.getString(8)!=null){
                            vo.setRwchrcd(rss.getString(8));
                        }
                        if(rss.getString(9)!=null){
                            vo.setRwptn(rss.getString(9));
                        }
                        if(rss.getDouble(10)!=0.0){
                            vo.setInqdr(rss.getDouble(10));
                        }
                        if(rss.getString(11)!=null){
                            vo.setMsqmt(rss.getString(11));
                        }
                        System.out.println(vo.getTm());
                        DdsDrRsvr existRsvr = ddsDrRsvrService.get(vo);
                        //对不存在的数据，进行保存
                        if(null==existRsvr){
                            ddsDrRsvrService.save(vo);
                        }
                    }
                    //关闭链接
                    sourceDB.close(rss,queryStatement,conn);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //logger.warn("同步水库水情数据出错："+e.getMessage());
            e.printStackTrace();
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