package com.chz.spring.impl;

import com.chz.spring.IWork;
import org.springframework.stereotype.Component;

@Component
public class WorkImpl implements IWork {
    public void print() {
        System.out.println("工作中");
    }
}
