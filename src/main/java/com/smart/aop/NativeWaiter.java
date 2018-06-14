package com.smart.aop;

import com.smart.annotation.NeedTest;

public class NativeWaiter implements Waiter {

    public void greetTo(String clientName) {
        System.out.println("NativeWaiter:greet to " + clientName + "...");
    }

    public void serveTo(String clientName) {
        System.out.println("NativeWaiter:serving to " + clientName + "...");
    }
    public void smile(String name , int num){
        System.out.println("smile to " + name + "," + num + "times");
    }
}
