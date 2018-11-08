package com.replay.dragon.rest.entity.rp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by RoyChan on 2018/10/23.
 */
@XmlRootElement(name = "data")
@XmlType(propOrder = {"trading", "noninlinetrading", "failing", "profitmarkingeffect", "rise", "fall", "marginfinancing", "foreigncapital"})
public class Data {

    private String trading;
    private String noninlinetrading;
    private String failing;
    private String profitmarkingeffect;
    private String rise;
    private String fall;
    private MarginFinancing marginfinancing;
    private Foreigncapital foreigncapital;

    @XmlElement(name = "trading")
    public String getTrading() {
        return trading;
    }

    public void setTrading(String trading) {
        this.trading = trading;
    }

    @XmlElement(name = "noninlinetrading")
    public String getNoninlinetrading() {
        return noninlinetrading;
    }

    public void setNoninlinetrading(String noninlinetrading) {
        this.noninlinetrading = noninlinetrading;
    }

    @XmlElement(name = "failing")
    public String getFailing() {
        return failing;
    }

    public void setFailing(String failing) {
        this.failing = failing;
    }

    @XmlElement(name = "profitmarkingeffect")
    public String getProfitmarkingeffect() {
        return profitmarkingeffect;
    }

    public void setProfitmarkingeffect(String profitmarkingeffect) {
        this.profitmarkingeffect = profitmarkingeffect;
    }

    @XmlElement(name = "rise")
    public String getRise() {
        return rise;
    }

    public void setRise(String rise) {
        this.rise = rise;
    }

    @XmlElement(name = "fall")
    public String getFall() {
        return fall;
    }

    public void setFall(String fall) {
        this.fall = fall;
    }

    @XmlElement(name = "marginfinancing")
    public MarginFinancing getMarginfinancing() {
        return marginfinancing;
    }

    public void setMarginfinancing(MarginFinancing marginfinancing) {
        this.marginfinancing = marginfinancing;
    }

    @XmlElement(name = "foreigncapital")
    public Foreigncapital getForeigncapital() {
        return foreigncapital;
    }

    public void setForeigncapital(Foreigncapital foreigncapital) {
        this.foreigncapital = foreigncapital;
    }
}
