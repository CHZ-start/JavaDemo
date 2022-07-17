package com.chz.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class TaskAop {

    private static final Logger log = LoggerFactory.getLogger(TaskAop.class);

    @Before(value = "execution(public void com.chz.spring.Task.doSomething(String))")
    public void BeforeMethod(JoinPoint joinPoint){
        //通过JointPoint对象获取目标方法签名对象
        //方法签名：一个方法的全部声明信息
        Signature signature = joinPoint.getSignature();
        //通过方法签名获取目标方法信息
        //获取方法名称
        String methodname = signature.getName();
        log.info("methodname：" + methodname);
        //获取修饰符
        int modifiers = signature.getModifiers();
        log.info("modifiers：" + modifiers);
        //获取声明类型
        String declaringTypeName = signature.getDeclaringTypeName();
        log.info("declaringTypeName：" + declaringTypeName);
        //获取传入实参列表
        Object[] args = joinPoint.getArgs();
        List<Object> argList = Arrays.asList(args);
        log.info("方法传入实参参数：" + argList);

        log.info("[AOP前置通知]--方法运行");
    }
    @AfterReturning(
            value = "execution(public void com.chz.spring.Task.doSomething(String))",
            returning = "ObjectMethodReturnValues"
    )
    public void AfterSuccess(JoinPoint joinPoint,Object ObjectMethodReturnValues){

        log.info("[AOP返回通知]--方法成功返回");
        log.info("目标方法返回值：" + ObjectMethodReturnValues);
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
