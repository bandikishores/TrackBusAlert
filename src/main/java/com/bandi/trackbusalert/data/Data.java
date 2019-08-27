
package com.bandi.trackbusalert.data;

import java.io.Serializable;

public class Data implements Serializable
{

    private String vn;
    private Integer isStale;
    private String lt;
    private String lg;
    private String lft;
    private Double sp;
    private Integer io;
    private Integer rs;
    private String sc;
    private Integer ac;
    private Double od;
    private final static long serialVersionUID = 7415377156863813938L;

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public Integer getIsStale() {
        return isStale;
    }

    public void setIsStale(Integer isStale) {
        this.isStale = isStale;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public String getLg() {
        return lg;
    }

    public void setLg(String lg) {
        this.lg = lg;
    }

    public String getLft() {
        return lft;
    }

    public void setLft(String lft) {
        this.lft = lft;
    }

    public Double getSp() {
        return sp;
    }

    public void setSp(Double sp) {
        this.sp = sp;
    }

    public Integer getIo() {
        return io;
    }

    public void setIo(Integer io) {
        this.io = io;
    }

    public Integer getRs() {
        return rs;
    }

    public void setRs(Integer rs) {
        this.rs = rs;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public Integer getAc() {
        return ac;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    public Double getOd() {
        return od;
    }

    public void setOd(Double od) {
        this.od = od;
    }

}
