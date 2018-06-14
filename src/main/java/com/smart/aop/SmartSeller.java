package com.smart.aop;

public class SmartSeller implements Seller {
    public void sell(String goods) {
        System.out.println("SmartSeller:" + goods);
    }
}
