package com.replay.dragon.rest.entity;

import com.codegen.jet.core.BaseDomain;

/**
 * Created by RoyChan on 2018/10/25.
 */
public class Pet extends BaseDomain {
    String name;
    String price;

    public Pet() {
    }

    public Pet(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

