package com.smart.proxy;

public class Hello implements IHello {
    public void sayHello(String name) {
        System.out.println("Hello World!" + name);
    }
}
