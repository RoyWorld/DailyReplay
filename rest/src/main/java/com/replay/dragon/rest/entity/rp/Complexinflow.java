package com.replay.dragon.rest.entity.rp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by RoyChan on 2018/10/23.
 */
@XmlRootElement(name = "complexinflow")
@XmlType(propOrder = {"inflows", "outflows"})
public class Complexinflow {

    private List<String> inflows;
    private List<String> outflows;

    @XmlElementWrapper(name = "inflows")
    @XmlElement(name = "inflow")
    public List<String> getInflows() {
        return inflows;
    }

    public void setInflows(List<String> inflows) {
        this.inflows = inflows;
    }

    @XmlElementWrapper(name = "outflows")
    @XmlElement(name = "outflow")
    public List<String> getOutflows() {
        return outflows;
    }

    public void setOutflows(List<String> outflows) {
        this.outflows = outflows;
    }
}
