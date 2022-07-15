package com.chz.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WorkProxy implements InvocationHandler {

    private Object object;

    public WorkProxy(Object object){
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;
        System.out.println("代理中");
        result = method.invoke(object,args);
        System.out.println("完成代理");
        return result;
    }
}
