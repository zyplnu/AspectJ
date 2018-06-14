package com.smart.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader() , IHello.class);
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        IHello iHello = (IHello) constructor.newInstance(new HWInvocationHandler(new Hello()));
        iHello.sayHello();*/

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles" , "true");
        IHello iHello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),
                                                new Class[]{IHello.class},new HWInvocationHandler(new Hello()));
        iHello.sayHello("zhangsan");
    }

}
