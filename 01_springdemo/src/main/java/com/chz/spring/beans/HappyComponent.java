package com.chz.spring.beans;

import org.apache.log4j.Logger;

public class HappyComponent {

    private static final Logger log = Logger.getLogger(HappyComponent.class);

    private String happyname;

    public String getHappyname() {
        return happyname;
    }

    public void setHappyname(String happyname) {
        this.happyname = happyname;
    }

    public void happyInitMethod() {
        log.info("HappyComponent初始化");
    }

    public void happyDestroyMethod() {
        log.info("HappyComponent销毁");
    }
}
