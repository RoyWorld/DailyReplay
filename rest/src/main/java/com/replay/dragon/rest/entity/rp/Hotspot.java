package com.replay.dragon.rest.entity.rp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by RoyChan on 2018/10/23.
 */
@XmlRootElement(name = "hotspot")
@XmlType(propOrder = {"name", "complexhot", "dragon", "sum"})
public class Hotspot {

    private String name;
    private String complexhot;
    private String dragon;
    private String sum;

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "complexhot")
    public String getComplexhot() {
        return complexhot;
    }

    public void setComplexhot(String complexhot) {
        this.complexhot = complexhot;
    }

    @XmlElement(name = "dragon")
    public String getDragon() {
        return dragon;
    }

    public void setDragon(String dragon) {
        this.dragon = dragon;
    }

    @XmlElement(name = "sum")
    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
