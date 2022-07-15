package com.chz.spring.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TaskAop {

    private static final Logger log = LoggerFactory.getLogger(TaskAop.class);

    @Before(value = "execution(public void com.chz.spring.Task.doSomething(String))")
    public void BeforeMethod(){
        log.info("[AOP前置通知]--方法运行");
    }
    @AfterReturning(value = "execution(public void com.chz.spring.Task.doSomething(String))")
    public void AfterSuccess(){
        log.info("[AOP返回通知]--方法成功返回");
    }
    @AfterThrowing(value = "execution(public void com.chz.spring.Task.doSomething(String))")
    public void AfterException(){
        log.info("[AOP异常通知]--方法抛异常了");
    }
    @After(value = "execution(public void com.chz.spring.Task.doSomething(String))")
    public void FinallyEnd(){
        log.info("[AOP后置通知]--方法运行");
    }

}
