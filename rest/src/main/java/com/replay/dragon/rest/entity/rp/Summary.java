package com.replay.dragon.rest.entity.rp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by RoyChan on 2018/10/23.
 */
@XmlRootElement(name = "summary")
@XmlType(propOrder = {"breaktradingrate", "contitradingrate", "sum"})
public class Summary {

    private String breaktradingrate;
    private String contitradingrate;
    private String sum;

    @XmlElement(name = "breaktradingrate")
    public String getBreaktradingrate() {
        return breaktradingrate;
    }

    public void setBreaktradingrate(String breaktradingrate) {
        this.breaktradingrate = breaktradingrate;
    }

    @XmlElement(name = "contitradingrate")
    public String getContitradingrate() {
        return contitradingrate;
    }

    public void setContitradingrate(String contitradingrate) {
        this.contitradingrate = contitradingrate;
    }

    @XmlElement(name = "sum")
    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
