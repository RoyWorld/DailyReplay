package com.replay.dragon.rest.entity.rp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by RoyChan on 2018/10/23.
 */
@XmlRootElement(name = "foreigncapital")
@XmlType(propOrder = {"sum", "sh", "sz"})
public class Foreigncapital {
    private String sum;
    private List<String> sh;
    private List<String> sz;

    @XmlElement(name = "sum")
    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    @XmlElementWrapper(name = "sh")
    @XmlElement(name = "s")
    public List<String> getSh() {
        return sh;
    }

    public void setSh(List<String> sh) {
        this.sh = sh;
    }

    @XmlElementWrapper(name = "sz")
    @XmlElement(name = "s")
    public List<String> getSz() {
        return sz;
    }

    public void setSz(List<String> sz) {
        this.sz = sz;
    }
}
