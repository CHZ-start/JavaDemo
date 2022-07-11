package com.chz.spring.beans;

public class FirstBean {

    private String name;

    private Bean01 bean01;

    public FirstBean() {
    }


    public FirstBean(String name, Bean01 bean01) {
        this.name = name;
        this.bean01 = bean01;
    }

    public Bean01 getBean01() {
        return bean01;
    }

    public void setBean01(Bean01 bean01) {
        this.bean01 = bean01;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
