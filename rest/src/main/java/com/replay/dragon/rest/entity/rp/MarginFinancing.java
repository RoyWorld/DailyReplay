package com.replay.dragon.rest.entity.rp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by RoyChan on 2018/10/30.
 */
@XmlRootElement(name = "marginfinancing")
@XmlType(propOrder = {"change", "sum"})
public class MarginFinancing {

    private String change;
    private String sum;

    @XmlElement(name = "change")
    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    @XmlElement(name = "sum")
    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
