package com.smart.designmodel;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        CarModel wcar = new WCar();
        wcar.excet();

        CarModel ocar = new OCar();
        ocar.excet();
    }

}
