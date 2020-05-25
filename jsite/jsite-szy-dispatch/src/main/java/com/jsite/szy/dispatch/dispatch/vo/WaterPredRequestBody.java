package com.jsite.szy.dispatch.dispatch.vo;

import com.jsite.busi.szy.dispatch.po.*;

import java.util.List;

/**
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-10-24 19:27
 */
public class WaterPredRequestBody {
    private List<DdsRdEcostt> p1;
    private List<DdsRdDevpar> p2;
    private List<DdsRdWun> p3;
    private List<DdsRdWupar> p4;
    private List<DdsRdWdmpar> p5;
    private List<DdsRdWnres> p6;
    private List<DdsRdWnres> p7;

    public List<DdsRdEcostt> getP1() {
        return p1;
    }

    public void setP1(List<DdsRdEcostt> p1) {
        this.p1 = p1;
    }

    public List<DdsRdDevpar> getP2() {
        return p2;
    }

    public void setP2(List<DdsRdDevpar> p2) {
        this.p2 = p2;
    }

    public List<DdsRdWun> getP3() {
        return p3;
    }

    public void setP3(List<DdsRdWun> p3) {
        this.p3 = p3;
    }

    public List<DdsRdWupar> getP4() {
        return p4;
    }

    public void setP4(List<DdsRdWupar> p4) {
        this.p4 = p4;
    }

    public List<DdsRdWdmpar> getP5() {
        return p5;
    }

    public void setP5(List<DdsRdWdmpar> p5) {
        this.p5 = p5;
    }

    public List<DdsRdWnres> getP6() {
        return p6;
    }

    public void setP6(List<DdsRdWnres> p6) {
        this.p6 = p6;
    }

    public List<DdsRdWnres> getP7() {
        return p7;
    }

    public void setP7(List<DdsRdWnres> p7) {
        this.p7 = p7;
    }
}
