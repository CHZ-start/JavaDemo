package com.chz.spring.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld2 {

    private static final Logger log = (Logger) LoggerFactory.getLogger(HelloWorld.class);

    private String springdemo;

    private HappyMachine happyMachine;

    public String getSpringdemo() {
        return springdemo;
    }

    public void setSpringdemo(String springdemo) {
        this.springdemo = springdemo;
    }

    public void doWork(){
        log.debug("component do work ...");
    }

    public HappyMachine getHappyMachine() {
        return happyMachine;
    }

    public void setHappyMachine(HappyMachine happyMachine) {
        this.happyMachine = happyMachine;
    }
}
