package com.learn.springboot1.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Person implements Serializable{


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @NotEmpty(message = "ID不能为空")
    @NotBlank(message = "ID不能为空")
    private String id;

    private String name;

    private String age;

}
