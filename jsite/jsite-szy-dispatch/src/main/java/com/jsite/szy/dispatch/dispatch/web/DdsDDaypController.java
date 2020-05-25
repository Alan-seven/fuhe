package com.jsite.szy.dispatch.dispatch.web;

import com.jsite.busi.szy.dispatch.dao.DdsRdIfresDao;
import com.jsite.busi.szy.dispatch.po.DdsRdIfres;
import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.service.DdsRdPService;
import com.jsite.busi.szy.evaluation.service.DdsDDaypService;
import com.jsite.busi.szy.evaluation.utils.DownLoadUtils;
import com.jsite.core.config.Global;
import com.jsite.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 向靖
 * 创建时间：2017-10-12 16:50
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/ddsDDayp")
public class DdsDDaypController extends BaseController{
    @Autowired
    private DdsDDaypService ddsDDaypService;
    @Autowired
    private DdsRdPService ddsRdPService;
    @Autowired
    private DdsRdIfresDao ddsRdIfresDao;

    @ResponseBody
    @RequestMapping("getRunInfoLast/{stationName}/{proCd}")
    public String getRunInfoLast( @PathVariable("stationName") String stationName,
                                  @PathVariable("proCd") String proCd,
                                  HttpServletResponse response) throws Exception{
        if(stationName.equals("南城")){
            stationName = "南丰";
        }
            List<Map<String,String>> lists = ddsDDaypService.getRunInfoLast(stationName,proCd);
        if(lists != null) {
            return renderString(response,lists);
        }else{
            return null;
        }
    }

    @ResponseBody
    @RequestMapping("getYear/{proCd}")
    public String getYear(@PathVariable("proCd") String proCd, HttpServletResponse response) throws Exception{
        DdsRdP ddsRdP= ddsRdPService.get(proCd);
        int year=Integer.parseInt(new SimpleDateFormat("yyyy").format(ddsRdP.getBgDt()));
        return renderString(response, year);
    }


    @ResponseBody
    @RequestMapping("getForecatData/{stationName}/{proCd}/{type}/{model}/{river}")
    public String getForecatData(@PathVariable("stationName") String stationName
                                ,@PathVariable("proCd") String proCd
                                ,@PathVariable("type") String type
                                ,@PathVariable("model") int model
                                ,@PathVariable("river") String river
                                ,@RequestBody List<Map> map
                                , HttpServletRequest request
                                , HttpServletResponse response) throws Exception{
        if(stationName.equals("南城")){
            stationName = "南丰";
        }
        if(type.equals("year")) return renderString(response, foryear(proCd,model,river,request,map));
        if(type.equals("month")){
                return renderString(response, forMonth(proCd, model,river,request,map));
        }
        if(type.equals("xun")) return renderString(response, forXun(proCd,model,river,request,map));
        else return null;
    }

    public Map forXun(String proCd,int model,String river,HttpServletRequest request,List<Map> jsonList) throws Exception {
        List<String> names = new ArrayList();
        List<Map> list = new ArrayList<>();
        DdsRdP ddsRdP = ddsRdPService.get(proCd);

        Date date1 = ddsRdP.getBgDt();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int year = Integer.parseInt(sdf.format(ddsRdP.getBgDt()).split("-")[0]);

        String format = sdf.format(date1);
        int month1 = Integer.parseInt(format.split("-")[1]);

        /*
        if (year > 2007) {
            String day = format.split("-")[2];
            String dateS = ddsDDaypService.formatStr((year - 10) + "-" + month1 + "-" + day);
            date1 = sdf.parse(dateS);
        }
        */


        if ("02".equals(river)) {
            names.add("沙子岭");
            names.add("南丰");
            names.add("廖坊");
            names.add("廖家湾");
            names.add("娄家村");
            names.add("李家渡");
            names.add("洪门");
        } else {
            names.add("茅洲");
        }

        Map resultMap = new HashMap();
        //灰色统计模型


        boolean flag;
        for (int j = 0; j < names.size(); j++) {
            flag = false;
            List<Map> getP1List = null;
            for (Map map : jsonList) {
                if (names.get(j).equals(map.get("station"))) {
                    getP1List = ddsDDaypService.getFormatImport(names.get(j), jsonList);
                    flag = true;
                    break;
                }
            }
            if ("洪门".equals(names.get(j))) {
                list = ddsDDaypService.getForecastToXun("洪门", date1, request);
            } else {
                list = ddsDDaypService.getForcastXun_sw(names.get(j), date1);
            }

            String SEC_CD = ddsDDaypService.getSecCd(names.get(j));

            for (int i = 0, concl; i < list.size(); i++) {
                String p6Str = list.get(i).get("p6").toString();
                if (!list.get(i).get("month").toString().equals("全年")) {
                    DdsRdIfres dsRdIfres = new DdsRdIfres();
                    dsRdIfres.setProCd(proCd);
                    dsRdIfres.setSecCd(SEC_CD);
                    String beginStr = null;
                    String endStr = null;
                    String[] strs = list.get(i).get("month").toString().split("月");
                    int month = Integer.parseInt(strs[0]);
                    String xunStr = strs[1];
                    if ("上".equals(xunStr)) {
                        beginStr = ddsDDaypService.formatStr(year + "-" + month + "-01");
                        endStr = ddsDDaypService.formatStr(year + "-" + month + "-11");
                    } else if ("中".equals(xunStr)) {
                        beginStr = ddsDDaypService.formatStr(year + "-" + month + "-11");
                        endStr = ddsDDaypService.formatStr(year + "-" + month + "-21");
                    } else {
                        beginStr = ddsDDaypService.formatStr(year + "-" + month + "-21");
                        if (month == 12) {
                            endStr = ddsDDaypService.formatStr((year + 1) + "-01-01");
                        } else {
                            endStr = ddsDDaypService.formatStr(year + "-" + (month + 1) + "-01");
                        }
                    }
                    dsRdIfres.setBgtm(java.sql.Date.valueOf(beginStr));
                    dsRdIfres.setEdtm(java.sql.Date.valueOf(endStr));
                    dsRdIfres.setMonth(Integer.parseInt(list.get(i).get("month").toString().substring(0, list.get(i).get("month").toString().indexOf("月"))));

                    dsRdIfres.setForW(Double.parseDouble(list.get(i).get("p1").toString()));
                    dsRdIfres.setLyW(Double.parseDouble(list.get(i).get("p2").toString()));
                    dsRdIfres.setLyRt(Double.parseDouble(list.get(i).get("p3").toString()));
                    dsRdIfres.setAnnW(Double.parseDouble(list.get(i).get("p4").toString()));
                    dsRdIfres.setAnoV(Double.parseDouble(list.get(i).get("p5").toString()));

                    if (flag) {
                        for (Map p1map : getP1List) {
                            if (p1map.get("month").equals(list.get(i).get("month").toString())) {
                                if (p1map.get("p1") != null) {
                                    double p1 = Double.parseDouble(p1map.get("p1").toString());
                                    double p2 = Double.parseDouble(list.get(i).get("p2").toString());
                                    double p3 = ddsDDaypService.division(p1 - p2);
                                    double p4 = Double.parseDouble(list.get(i).get("p4").toString());
                                    double p5 = 0;
                                    if (p4 != 0) {
                                        p5 = ddsDDaypService.division((p1 - p4) / p4 * 100d);
                                    }
                                    dsRdIfres.setForW(p1);
                                    dsRdIfres.setLyW(p2);
                                    dsRdIfres.setLyRt(p3);
                                    dsRdIfres.setAnnW(p4);
                                    dsRdIfres.setAnoV(p5);
                                    p6Str = ddsDDaypService.getP6(p5);
                                }
                            }
                        }
                    }
                    if (p6Str.contains("特丰")) concl = 1;
                    else if (p6Str.contains("偏丰")) concl = 2;
                    else if (p6Str.contains("平")) concl = 3;
                    else if (p6Str.contains("偏枯")) concl = 4;
                    else if (p6Str.contains("特枯")) concl = 5;
                    else concl = 0;
                    dsRdIfres.setConcl(concl);
                    if (ddsRdIfresDao.get(dsRdIfres) == null) ddsRdIfresDao.save(dsRdIfres);
                    else ddsRdIfresDao.update(dsRdIfres);

                }
            }
            resultMap.put(names.get(j), list);
            if (ddsRdPService.selectSta(ddsRdP) == -1) {
                ddsRdPService.updateSta(new DdsRdP() {{
                    setProCd(proCd);
                    setSta(0);
                }});
            }
        }
        return resultMap;
    }


    public Map forMonth(String proCd,int model,String river,HttpServletRequest request,List<Map> jsonList) throws Exception {
        Map resultMap = new HashMap();
        List<Map> list = new ArrayList<>();
        DdsRdIfres dsRdIfres = new DdsRdIfres();
        DdsRdP ddsRdP = ddsRdPService.get(proCd);
        Date date1 = ddsRdP.getBgDt();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int year = Integer.parseInt(sdf.format(ddsRdP.getBgDt()).split("-")[0]);

        String format = sdf.format(date1);
        int month1 = Integer.parseInt(format.split("-")[1]);

        if (month1 == 12) {
            return null;
        }
        /*
        if(year>2007){
            String day = format.split("-")[2];
            String dateS = ddsDDaypService.formatStr((year-10)+"-"+month1+"-"+day);
            date1 = sdf.parse(dateS);
        }
*/

        List<String> names = new ArrayList();
        if ("02".equals(river)) {

            names.add("沙子岭");
            names.add("南丰");
            names.add("廖坊");
            names.add("廖家湾");
            names.add("娄家村");
            names.add("李家渡");

        } else {
            names.add("茅洲");
        }

        boolean flag;
        for (int j = 0; j < names.size(); j++) {
            flag = false;
            List<Map> getP1List = null;
            for (Map map : jsonList) {
                if (names.get(j).equals(map.get("station"))) {
                    getP1List = ddsDDaypService.getFormatImport(names.get(j),jsonList);
                    flag = true;
                    break;
                }
            }

            if (model != 2) {//灰色统计模型
                list = ddsDDaypService.getNextMonth(names.get(j), date1, request);
            } else if (model == 2) {
                list = ddsDDaypService.getForecastMonth_sw(names.get(j), date1);
            }

            String SEC_CD = ddsDDaypService.getSecCd(names.get(j));
            for (int i = 0, concl; i < list.size(); i++) {
                String p6Str = list.get(i).get("p6").toString();
                if (!"全年".equals(list.get(i).get("month").toString())) {
                    dsRdIfres.setProCd(proCd);
                    dsRdIfres.setSecCd(SEC_CD);
                    int month = Integer.parseInt(list.get(i).get("month").toString().substring(0, list.get(i).get("month").toString().indexOf("月")));
                    String beginStr = ddsDDaypService.formatStr(year + "-" + month + "-01");
                    String endStr = null;
                    if (month == 12) {
                        endStr = ddsDDaypService.formatStr((year + 1) + "-01-01");
                    } else {
                        endStr = ddsDDaypService.formatStr(year + "-" + (month + 1) + "-01");
                    }
                    dsRdIfres.setBgtm(java.sql.Date.valueOf(beginStr));
                    dsRdIfres.setEdtm(java.sql.Date.valueOf(endStr));
                    dsRdIfres.setMonth(Integer.parseInt(list.get(i).get("month").toString().substring(0, list.get(i).get("month").toString().indexOf("月"))));
                    double p1 = Double.parseDouble(list.get(i).get("p1").toString());
                    double p2 = Double.parseDouble(list.get(i).get("p2").toString());
                    double p3 = ddsDDaypService.division(p1 - p2);
                    double p4 = Double.parseDouble(list.get(i).get("p4").toString());
                    double p5 = 0;
                    if (p4 != 0) {
                        p5 = ddsDDaypService.division((p1 - p4) / p4 * 100d);
                    }
                    dsRdIfres.setForW(p1);
                    dsRdIfres.setLyW(p2);
                    dsRdIfres.setLyRt(p3);
                    dsRdIfres.setAnnW(p4);
                    dsRdIfres.setAnoV(p5);
                    if(flag) {
                        for (Map p1map : getP1List) {
                            if (p1map.get("month").equals(list.get(i).get("month").toString())) {
                                if (p1map.get("p1") != null) {
                                    p1 = Double.parseDouble(p1map.get("p1").toString());
                                    p2 = Double.parseDouble(list.get(i).get("p2").toString());
                                    p3 = ddsDDaypService.division(p1 - p2);
                                    p4 = Double.parseDouble(list.get(i).get("p4").toString());
                                    p5 = 0;
                                    if (p4 != 0) {
                                        p5 = ddsDDaypService.division((p1 - p4) / p4 * 100d);
                                    }
                                    dsRdIfres.setForW(p1);
                                    dsRdIfres.setLyW(p2);
                                    dsRdIfres.setLyRt(p3);
                                    dsRdIfres.setAnnW(p4);
                                    dsRdIfres.setAnoV(p5);
                                    p6Str = ddsDDaypService.getP6(p5);
                                }
                            }
                        }
                    }
                    if (p6Str.contains("特丰")) concl = 1;
                    else if (p6Str.contains("偏丰")) concl = 2;
                    else if (p6Str.contains("平")) concl = 3;
                    else if (p6Str.contains("偏枯")) concl = 4;
                    else if (p6Str.contains("特枯")) concl = 5;
                    else concl = 0;
                    dsRdIfres.setConcl(concl);
                    if (ddsRdIfresDao.get(dsRdIfres) == null) ddsRdIfresDao.save(dsRdIfres);
                    else ddsRdIfresDao.update(dsRdIfres);
                }
            }
            resultMap.put(names.get(j), list);
        }
        if ("02".equals(river)) {
            boolean flag1 = false;
            List<Map> ListHmP1List = null;
            for (Map map : jsonList) {
                if ("洪门".equals(map.get("station"))) {
                    flag1 = true;
                    ListHmP1List = ddsDDaypService.getFormatImport("洪门",jsonList);
                    break;
                }
            }
            List<Map> listHM = ddsDDaypService.getForcastData("洪门", year, request);

            List<Map> HMlist = new ArrayList<>();
            //加入洪门的结果
            for (int i = 0; i < listHM.size(); i++) {
                if (!listHM.get(i).get("month").toString().equals("全年")) {
                    String[] strs = listHM.get(i).get("month").toString().split("月");
                    int getMonth = Integer.parseInt(strs[0]);
                    int concl = 0;
                    String p6HmStr = listHM.get(i).get("p6").toString();

                    dsRdIfres.setForW(Double.parseDouble(listHM.get(i).get("p1").toString()));
                    dsRdIfres.setLyW(Double.parseDouble(listHM.get(i).get("p2").toString()));
                    dsRdIfres.setLyRt(Double.parseDouble(listHM.get(i).get("p3").toString()));
                    dsRdIfres.setAnnW(Double.parseDouble(listHM.get(i).get("p4").toString()));
                    dsRdIfres.setAnoV(Double.parseDouble(listHM.get(i).get("p5").toString()));

                    if (getMonth >= month1) {
                        dsRdIfres.setProCd(proCd);
                        dsRdIfres.setSecCd(ddsDDaypService.getSecCd("洪门"));
                        String beginStr = ddsDDaypService.formatStr(year + "-" + getMonth + "-01");
                        String endStr = "";
                        if (getMonth == 12) {
                            endStr = ddsDDaypService.formatStr((year + 1) + "-01-01");
                        } else {
                            endStr = ddsDDaypService.formatStr((year) + "-" + (getMonth + 1) + "-01");
                        }
                        HMlist.add(listHM.get(i));
                        dsRdIfres.setBgtm(java.sql.Date.valueOf(beginStr));
                        dsRdIfres.setEdtm(java.sql.Date.valueOf(endStr));
                        dsRdIfres.setMonth(getMonth);
                        if(flag1){
                            for(Map p1Hmmap : ListHmP1List){
                                if(p1Hmmap.get("month").equals(listHM.get(i).get("month").toString())){
                                    if(p1Hmmap.get("p1")!=null){
                                        double p1 = Double.parseDouble(p1Hmmap.get("p1").toString());
                                        double p2 = Double.parseDouble(listHM.get(i).get("p2").toString());
                                        double p3 = ddsDDaypService.division(p1-p2);
                                        double p4 = Double.parseDouble(listHM.get(i).get("p4").toString());
                                        double p5 = 0;
                                        if (p4 != 0) {
                                            p5 = ddsDDaypService.division((p1 - p4) / p4 * 100d);
                                        }
                                        dsRdIfres.setForW(p1);
                                        dsRdIfres.setLyW(p2);
                                        dsRdIfres.setLyRt(p3);
                                        dsRdIfres.setAnnW(p4);
                                        dsRdIfres.setAnoV(p5);
                                        p6HmStr = ddsDDaypService.getP6(p5);
                                    }
                                }
                            }
                        }
                        if (p6HmStr.contains("特丰")) concl = 1;
                        else if (p6HmStr.contains("偏丰")) concl = 2;
                        else if (p6HmStr.contains("平")) concl = 3;
                        else if (p6HmStr.contains("偏枯")) concl = 4;
                        else if (p6HmStr.contains("特枯")) concl = 5;
                        else concl = 0;
                        dsRdIfres.setConcl(concl);
                        if (ddsRdIfresDao.get(dsRdIfres) == null) ddsRdIfresDao.save(dsRdIfres);
                        else ddsRdIfresDao.update(dsRdIfres);
                    }
                }
            }
            resultMap.put("洪门", HMlist);
        }
        if (ddsRdPService.selectSta(ddsRdP) == -1) {
            ddsRdPService.updateSta(new DdsRdP() {{
                setProCd(proCd);
                setSta(0);
            }});
        }
        return resultMap;
    }


    public Map foryear(String proCd,int model,String river,HttpServletRequest request,List<Map> jsonList) throws Exception {
        Map resultMap = new HashMap();
        DdsRdP ddsRdP= ddsRdPService.get(proCd);
        int year=Integer.parseInt(new SimpleDateFormat("yyyy").format(ddsRdP.getBgDt()));
        /*
        if(year>2007){
            year = year-10;
        }*/
        List<String> names = new ArrayList();
        if("02".equals(river)){

            names.add("沙子岭");
            names.add("南丰");
            names.add("廖坊");
            names.add("廖家湾");
            names.add("娄家村");

            names.add("李家渡");

            names.add("洪门");



        }else{
            names.add("茅洲");
        }
        //解析传过来的数据
        boolean flag;
        List<Map> list = new ArrayList<>();
            for(int j = 0;j<names.size();j++) {
                flag = false;
                if(jsonList.size()>0) {
                    for (Map map : jsonList) {
                        if (names.get(j).equals(map.get("station"))) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) {
                    list = ddsDDaypService.getImportDataYear(names.get(j), jsonList, year);
                } else {
                    if (model != 2) {
                        list = ddsDDaypService.getForcastData(names.get(j), year, request);
                    } else if (model == 2) {
                        list = ddsDDaypService.getForecastYear_sw(names.get(j), year);
                    }
                }
                String SEC_CD = ddsDDaypService.getSecCd(names.get(j));
                for (int i = 0,concl; i < list.size(); i++) {
                    if(list.get(i).get("p6").toString().contains("特丰")) concl=1;
                    else if(list.get(i).get("p6").toString().contains("偏丰")) concl=2;
                    else if(list.get(i).get("p6").toString().contains("平"))  concl=3;
                    else if(list.get(i).get("p6").toString().contains("偏枯"))  concl=4;
                    else if(list.get(i).get("p6").toString().contains("特枯"))  concl=5;
                    else concl=0;
                    if (!list.get(i).get("month").toString().equals("全年")) {
                        DdsRdIfres dsRdIfres = new DdsRdIfres();
                        dsRdIfres.setProCd(proCd);
                        dsRdIfres.setSecCd(SEC_CD);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        int month = Integer.parseInt(list.get(i).get("month").toString().substring(0, list.get(i).get("month").toString().indexOf("月")));
                        String beginStr = ddsDDaypService.formatStr((year)+ "-" + month + "-01");
                        String endStr = null;
                        if (month == 12) {
                            endStr = ddsDDaypService.formatStr((year + 1 ) + "-01-01");
                        } else {
                            endStr = ddsDDaypService.formatStr((year) + "-" + (month + 1) + "-01");
                        }
                        dsRdIfres.setBgtm(java.sql.Date.valueOf(beginStr));
                        dsRdIfres.setEdtm(java.sql.Date.valueOf(endStr));
                        dsRdIfres.setMonth(Integer.parseInt(list.get(i).get("month").toString().substring(0, list.get(i).get("month").toString().indexOf("月"))));
                        dsRdIfres.setForW(Double.parseDouble(list.get(i).get("p1").toString()));
                        dsRdIfres.setLyW(Double.parseDouble(list.get(i).get("p2").toString()));
                        dsRdIfres.setLyRt(Double.parseDouble(list.get(i).get("p3").toString()));
                        dsRdIfres.setAnnW(Double.parseDouble(list.get(i).get("p4").toString()));
                        dsRdIfres.setAnoV(Double.parseDouble(list.get(i).get("p5").toString()));
                        dsRdIfres.setConcl(concl);
                        if (ddsRdIfresDao.get(dsRdIfres)==null) ddsRdIfresDao.save(dsRdIfres);
                        else ddsRdIfresDao.update(dsRdIfres);
                    }
                }
                resultMap.put (names.get(j),list);
                if (ddsRdPService.selectSta(ddsRdP) == -1) {
                    ddsRdPService.updateSta(new DdsRdP() {{
                        setProCd(proCd);
                        setSta(0);
                    }});
                }
            }
            return resultMap;

    }

    @ResponseBody
    @RequestMapping("getStationInfo/{river}")
    public String getForecatData( @PathVariable("river") String river,
            HttpServletResponse response) throws Exception{
        return renderString(response, ddsDDaypService.getStationInfo(river));
    }
    @ResponseBody
    @RequestMapping("getAvgToYear/{stationName}")
    public String getAvgToYear(@PathVariable("stationName") String stationName, HttpServletResponse response) throws Exception{
        if(stationName.equals("茅洲")) {
            return renderString(response, ddsDDaypService.getAvgToYear("芦溪"));
        }else{
            return renderString(response, ddsDDaypService.getAvgToYear(stationName));
        }
    }
    @ResponseBody
    @RequestMapping("getAvgToMonth/{stationName}/{year}")
    public String getAvgToMonth(@PathVariable("stationName") String stationName, @PathVariable("year") String year, HttpServletResponse response) throws Exception{
       if(stationName.equals("茅洲")) {
           return renderString(response, ddsDDaypService.getAvgToMonth_con("芦溪" ,year));
       }
        return renderString(response, ddsDDaypService.getAvgToMonth_con(stationName, year));
    }


    /**
     * 上传Excel,读取Excel中内容
     * @param file
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "getExcel/{type}",method = RequestMethod.POST)
    @ResponseBody
    public List batchimport(@RequestParam(value = "filename")MultipartFile file,@PathVariable("type")String type, HttpServletRequest request,HttpServletResponse response) throws IOException {
        //创建处理EXCEL
        //将数据返回前台
        return ddsDDaypService.getExcelInfo(file);

        /*
        HttpSession session = request.getSession();
        session.setAttribute("excelInfo",map);
        if(map!=null||map.size()>0){
            return renderString(response,true);
        }else{
            return renderString(response,false);
        }
        */
    }
    /**
     * 下载Excel模板
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("downloadExcle/{type}")
    public String download( @PathVariable("type")String type ,HttpServletRequest request, HttpServletResponse response) {

        try {
//            String path = ResourceUtils.getURL("classPath:model").getPath();
//            String path = request.getSession().getServletContext()
//                    .getRealPath("/webapp/model");
//            String path =  DdsDDaypController.class.getClassLoader().getResource("webapp").getPath();
//            String path = Global.getConfig("model");
            String path = "";
            String path1 = request.getSession().getServletContext().getRealPath("/");
            String path2 = path1.split("target")[0] + "src/main/webapp/model";
            File file1 = new File(path1+"/yearModel.xls");
            File file2 = new File(path2+"/yearModel.xls");
            if(file2.exists()){
                path = path2;
            }else if(file1.exists()){
                path = path1;
            }else{
                path = Global.getConfig("uploadFile") + "/model";
            }
            String fileName = "";
            if("xun".equals(type)) {
                fileName= "xunModel.xls";
            }else if("month".equals(type)){
                fileName = "monthModel.xls";
            }else{
                fileName = "yearModel.xls";
            }
            String filePath = path + "\\" + fileName;
            DownLoadUtils.downLoadFile(filePath, response, fileName, "xls");//E:\work\pro\jsite\jsite\jsite-szy-dispatch\target\jsite-szy-dispatch\model\yearModel.xls
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


//    @RequestMapping(value = "getParam",method = RequestMethod.POST)
//    @ResponseBody
//    public String getParamData(@RequestBody Map map,HttpServletResponse response){
//        Object param = map.get("param");
//        return null;
//    }


}




