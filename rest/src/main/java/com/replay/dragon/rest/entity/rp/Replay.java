package com.replay.dragon.rest.entity.rp;

import com.codegen.jet.core.BaseDomain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by RoyChan on 2018/10/23.
 */
@XmlRootElement(name = "replay")
@XmlType(propOrder = {"data", "complexinflow", "marketreview", "hotspot", "sympatheticstock"})
public class Replay extends BaseDomain{

    private Data data;

    private Complexinflow complexinflow;

    private Marketreview marketreview;

    private List<Hotspot> hotspot;

    private Sympatheticstock sympatheticstock;

    @XmlElement(name = "data")
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @XmlElement(name = "complexinflow")
    public Complexinflow getComplexinflow() {
        return complexinflow;
    }

    public void setComplexinflow(Complexinflow complexinflow) {
        this.complexinflow = complexinflow;
    }

    @XmlElement(name = "marketreview")
    public Marketreview getMarketreview() {
        return marketreview;
    }

    public void setMarketreview(Marketreview marketreview) {
        this.marketreview = marketreview;
    }

    @XmlElementWrapper(name = "hotspot")
    @XmlElement(name = "h")
    public List<Hotspot> getHotspot() {
        return hotspot;
    }

    public void setHotspot(List<Hotspot> hotspot) {
        this.hotspot = hotspot;
    }

    @XmlElement(name = "sympatheticstock")
    public Sympatheticstock getSympatheticstock() {
        return sympatheticstock;
    }

    public void setSympatheticstock(Sympatheticstock sympatheticstock) {
        this.sympatheticstock = sympatheticstock;
    }
}
