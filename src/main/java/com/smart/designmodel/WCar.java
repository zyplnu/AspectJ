package com.smart.designmodel;

/**
 * 大众车
 */
public class WCar extends CarModel {
    protected void start() {
        System.out.println("大众车启动，，，突突突");
    }

    protected void stop() {
        System.out.println("大众车停车。。。");
    }
}
