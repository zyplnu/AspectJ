package com.smart.aop;

import com.smart.annotation.NeedTest;

public class NaughtyWaiter implements Waiter {

    @NeedTest
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiter:greet to " + clientName + "...");
    }

    public void serveTo(String clientName) {

    }
}
