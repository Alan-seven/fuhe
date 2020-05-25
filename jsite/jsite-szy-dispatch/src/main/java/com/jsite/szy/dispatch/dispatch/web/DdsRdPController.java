package com.jsite.szy.dispatch.dispatch.web;

import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.service.DdsRdPService;
import com.jsite.core.page.Page;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.dispatch.vo.DdsRdPVO;
import com.jsite.szy.dispatch.dispatch.vo.TextValueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-09-22 17:33
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/ddsRdP")
public class DdsRdPController extends BaseController {

    @Autowired
    private DdsRdPService ddsRdPService;

    @ResponseBody
    @RequestMapping(value = "get/{proCd}", method = RequestMethod.GET)
    public String getOne(HttpServletResponse response,
                         @PathVariable String proCd) {
        DdsRdP ddsRdP = new DdsRdP();
        ddsRdP.setProCd(proCd);
        return renderString(response, ddsRdPService.get(ddsRdP));
    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(HttpServletResponse response,
                       @RequestBody DdsRdP ddsRdP) {
        return renderString(response, ddsRdPService.saveOne(ddsRdP));
    }

    @ResponseBody
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String remove(HttpServletResponse response,
                         @RequestBody DdsRdP ddsRdP) {
        return renderString(response, ddsRdPService.remove(ddsRdP));
    }

    @ResponseBody
    @RequestMapping(value = "listOfPage")
    public String list(@RequestParam(value = "type", required = false) String type,
                       @RequestParam(value = "dateBegin", required = false) Date dateBegin,
                       @RequestParam(value = "dateEnd", required = false) Date dateEnd,
                       @RequestParam(value = "user", required = false) String user,
                       @RequestParam(value = "page", defaultValue = "0") Integer pageNum,
                       @RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
                       String river,
                       HttpServletResponse response) {
        Page page = new Page<DdsRdP>();
        DdsRdP condition = new DdsRdP();
        condition.setProTp(type);
        condition.setBgDt(dateBegin);
        condition.setEdDt(dateEnd);
        condition.setProducer(user);
        condition.setRvCd(river);
        page.setPageNo(pageNum);
        page.setPageSize(pageSize);
        Page<DdsRdP> result = ddsRdPService.getPage(page, condition);
        List<DdsRdPVO> dataList = new ArrayList<>();
        for (DdsRdP ddsRdP : result.getList()) {
            DdsRdPVO temp = new DdsRdPVO();
            temp.setProCd(ddsRdP.getProCd().trim());
            temp.setProNm(ddsRdP.getProNm());
            temp.setCrDt(ddsRdP.getCrDt());
            temp.setProducer(ddsRdP.getProducer());
            temp.setSta(ddsRdP.getSta());
            temp.setBgDt(ddsRdP.getBgDt());
            temp.setEdDt(ddsRdP.getEdDt());
            temp.setNt(ddsRdP.getNt());
            dataList.add(temp);
        }
        Page<DdsRdPVO> result2 = new Page<>();
        result2.setList(dataList);
        result2.setPageSize(result.getPageSize());
        result2.setPageNo(result.getPageNo());
        result2.setCount(result.getCount());
        return renderString(response, result2);
    }

    @ResponseBody
    @RequestMapping(value = "listAllSolutionsByProTp")
    public String listAllSolutionsByProTp(HttpServletResponse response, String proTp, String river) {
        DdsRdP ddsRdP = new DdsRdP();
        ddsRdP.setProTp(proTp);
        ddsRdP.setRvCd(river);
        List<DdsRdP> list = ddsRdPService.list(ddsRdP);
        List<TextValueVO> parseData = new ArrayList<>();
        TextValueVO temp;
        for (DdsRdP d : list) {
            temp = new TextValueVO();
            temp.setText(d.getProNm().trim());
            temp.setValue(d.getProCd().trim());
            parseData.add(temp);
        }
        return renderString(response, parseData);
    }

}
