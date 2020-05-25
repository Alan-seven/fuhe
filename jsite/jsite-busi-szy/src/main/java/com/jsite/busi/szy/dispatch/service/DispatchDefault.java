package com.jsite.busi.szy.dispatch.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-10-30 16:54
 */
public class DispatchDefault {
    public static final Map<String, List<String>> SUB_CD_TO_AD_CDS_MAP = new HashMap<String, List<String>>(){
        {
            put("02", Arrays.asList(
                    "361000",
                    "361002",
                    "361021",
                    "361022",
                    "361023",
                    "361024",
                    "361025",
                    "361026",
                    "361027",
                    "361028",
                    "361029",
                    "361030")
            );
            put("03", Arrays.asList(
                    "360323",
                    "360902",
                    "360983",
                    "360923",
                    "360982",
                    "360521",
                    "360502")
            );
        }
    };
}
