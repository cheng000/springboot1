package com.learn.springboot1.entity;

import java.io.Serializable;

public class PersonName implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
