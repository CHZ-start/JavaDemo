package com.chz.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class WorkAop {

    private static final Logger log = LoggerFactory.getLogger(WorkAop.class);

    @Before(value = "execution(public void com.chz.spring.IWork.print())")
    public void BeforeMethod(){
        log.info("[AOP前置通知]--方法运行");
    }
}
