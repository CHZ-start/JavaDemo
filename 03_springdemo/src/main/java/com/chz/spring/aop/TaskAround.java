package com.chz.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TaskAround {

    private static final Logger log = LoggerFactory.getLogger(TaskAround.class);

    @Pointcut("execution(public String com.chz.spring.Task.makeSomething(..))")
    public void taskPointCut(){}

    @Around(value = "taskPointCut()")
    public Object aroundTask(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();

        Signature signature = joinPoint.getSignature();

        String methodname = signature.getName();

        Object returnValue = null;

        try{
            log.info("[AOP环绕通知]：方法执行前");
            returnValue = joinPoint.proceed(args);
            log.info("[AOP环绕通知]：方法执行后");
        }catch (Throwable e){
            log.info("[AOP环绕通知]：方法异常");
        }finally {
            log.info("[AOP环绕通知]：方法最终结束");
        }
        return returnValue;
    }
}
