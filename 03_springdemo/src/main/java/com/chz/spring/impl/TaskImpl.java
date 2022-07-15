package com.chz.spring.impl;

import com.chz.spring.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskImpl implements Task{

    public void doSomething(String things) {
        System.out.println("I'm doing " + things);
    }

    public String makeSomething(String seed) {
        return seed + "--" + seed;
    }
}
