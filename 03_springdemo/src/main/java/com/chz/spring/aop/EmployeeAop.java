package com.chz.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class EmployeeAop {

    @Pointcut(value = "execution(public void com.chz.spring.EmployeeService.getEmpList(..))")
    public void empPointcut(){}

    @Around(value = "empPointcut()")
    public void aroundtest(ProceedingJoinPoint joinPoint){
        try {
            log.info("[AOP]方法执行前");
            joinPoint.proceed();
            log.info("[AOP]方法执行后");
        }
        catch (Throwable throwable) {
            log.info("[AOP]方法异常");
        } finally {
            log.info("[AOP]方法最终结束");
        }
    }
}
