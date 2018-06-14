package com.smart.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class HWInvocationHandler implements InvocationHandler {

    private Object target;

    public HWInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--插入前置通知--");
        Object result = method.invoke(target,args);
        System.out.println("--插入后置通知--");
        return result;
    }
}
