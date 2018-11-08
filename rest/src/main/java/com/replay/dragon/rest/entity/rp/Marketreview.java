package com.replay.dragon.rest.entity.rp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by RoyChan on 2018/10/23.
 */
@XmlRootElement(name = "marketreview")
@XmlType(propOrder = {"market", "sympatheticstock", "summary"})
public class Marketreview {

    private String market;
    private Sympatheticstock sympatheticstock;
    private Summary summary;

    @XmlElement(name = "market")
    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    @XmlElement(name = "sympatheticstock")
    public Sympatheticstock getSympatheticstock() {
        return sympatheticstock;
    }

    public void setSympatheticstock(Sympatheticstock sympatheticstock) {
        this.sympatheticstock = sympatheticstock;
    }

    @XmlElement(name = "summary")
    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}
