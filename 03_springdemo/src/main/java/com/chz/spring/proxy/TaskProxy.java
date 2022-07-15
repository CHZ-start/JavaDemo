package com.chz.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TaskProxy implements InvocationHandler {

    private Object object;

    public TaskProxy(Object object){
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("该方法将被代理");
        result = method.invoke(object,args);
        System.out.println("该方法已被代理");
        return result;
    }
}
