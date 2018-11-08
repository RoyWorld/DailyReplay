package com.replay.dragon.rest.entity.rp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by RoyChan on 2018/10/23.
 */
@XmlRootElement(name = "stockdescribe")
@XmlType(propOrder = {"n", "d"})
public class StockDescribe {
    private String n;
    private String d;


    @XmlElement(name = "n")
    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    @XmlElement(name = "d")
    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
