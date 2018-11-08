package com.replay.dragon.rest.entity.rp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by RoyChan on 2018/10/23.
 */
@XmlRootElement(name = "sympatheticstock")
@XmlType(propOrder = {"dragon", "dragontwo", "onetrading", "twotrading", "threetrading", "fourtrading", "breaktrading", "mainbreaktrading", "nomainbreaktrading", "bigfall", "subnewstock", "stoptrade"})
public class Sympatheticstock {
    private List<StockDescribe> dragon;
    private List<StockDescribe> dragontwo;
    private List<StockDescribe> onetrading;
    private List<StockDescribe> twotrading;
    private List<StockDescribe> threetrading;
    private List<StockDescribe> fourtrading;
    private List<StockDescribe> breaktrading;
    private List<StockDescribe> mainbreaktrading;
    private List<StockDescribe> nomainbreaktrading;
    private List<StockDescribe> bigfall;
    private List<StockDescribe> subnewstock;
    private List<StockDescribe> stoptrade;

    @XmlElementWrapper(name = "dragon")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getDragon() {
        return dragon;
    }

    public void setDragon(List<StockDescribe> dragon) {
        this.dragon = dragon;
    }

    @XmlElementWrapper(name = "dragontwo")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getDragontwo() {
        return dragontwo;
    }

    public void setDragontwo(List<StockDescribe> dragontwo) {
        this.dragontwo = dragontwo;
    }

    @XmlElementWrapper(name = "onetrading")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getOnetrading() {
        return onetrading;
    }

    public void setOnetrading(List<StockDescribe> onetrading) {
        this.onetrading = onetrading;
    }

    @XmlElementWrapper(name = "twotrading")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getTwotrading() {
        return twotrading;
    }

    public void setTwotrading(List<StockDescribe> twotrading) {
        this.twotrading = twotrading;
    }

    @XmlElementWrapper(name = "threetrading")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getThreetrading() {
        return threetrading;
    }

    public void setThreetrading(List<StockDescribe> threetrading) {
        this.threetrading = threetrading;
    }

    @XmlElementWrapper(name = "fourtrading")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getFourtrading() {
        return fourtrading;
    }

    public void setFourtrading(List<StockDescribe> fourtrading) {
        this.fourtrading = fourtrading;
    }

    @XmlElementWrapper(name = "breaktrading")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getBreaktrading() {
        return breaktrading;
    }

    public void setBreaktrading(List<StockDescribe> breaktrading) {
        this.breaktrading = breaktrading;
    }

    @XmlElementWrapper(name = "mainbreaktrading")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getMainbreaktrading() {
        return mainbreaktrading;
    }

    public void setMainbreaktrading(List<StockDescribe> mainbreaktrading) {
        this.mainbreaktrading = mainbreaktrading;
    }

    @XmlElementWrapper(name = "nomainbreaktrading")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getNomainbreaktrading() {
        return nomainbreaktrading;
    }

    public void setNomainbreaktrading(List<StockDescribe> nomainbreaktrading) {
        this.nomainbreaktrading = nomainbreaktrading;
    }

    @XmlElementWrapper(name = "bigfall")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getBigfall() {
        return bigfall;
    }

    public void setBigfall(List<StockDescribe> bigfall) {
        this.bigfall = bigfall;
    }

    @XmlElementWrapper(name = "subnewstock")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getSubnewstock() {
        return subnewstock;
    }

    public void setSubnewstock(List<StockDescribe> subnewstock) {
        this.subnewstock = subnewstock;
    }

    @XmlElementWrapper(name = "stoptrade")
    @XmlElement(name = "stockdescribe")
    public List<StockDescribe> getStoptrade() {
        return stoptrade;
    }

    public void setStoptrade(List<StockDescribe> stoptrade) {
        this.stoptrade = stoptrade;
    }
}
