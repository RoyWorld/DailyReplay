package com.replay.dragon.rest.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Created by RoyChan on 2018/10/18.
 */
@XmlRootElement(name = "principle")
@XmlType(propOrder = {"selects", "buys", "sells"})
public class Principle implements Serializable{

    private static final long serialVersionUID = -1039517584942325331L;
    private List<String> selects;
    private List<String> buys;
    private List<String> sells;

    @XmlElementWrapper(name = "selects")
    @XmlElement(name = "select")
    public List<String> getSelects() {
        return selects;
    }

    public void setSelects(List<String> selects) {
        this.selects = selects;
    }

    @XmlElementWrapper(name = "buys")
    @XmlElement(name = "buy")
    public List<String> getBuys() {
        return buys;
    }

    public void setBuys(List<String> buys) {
        this.buys = buys;
    }

    @XmlElementWrapper(name = "sells")
    @XmlElement(name = "sell")
    public List<String> getSells() {
        return sells;
    }

    public void setSells(List<String> sells) {
        this.sells = sells;
    }

    @Override
    public String toString() {
        return "Principle{" +
                "selects=" + selects +
                ", buys=" + buys +
                ", sells=" + sells +
                '}';
    }
}
