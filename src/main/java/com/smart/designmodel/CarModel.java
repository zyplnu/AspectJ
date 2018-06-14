package com.smart.designmodel;

/**
 * 汽车模型
 * 模板模式
 */
public abstract class CarModel {

    protected abstract void start();

    protected abstract void stop();

    /**
     * 用户并不关注你的车是怎么启动和怎么关闭的，可以开可以停就可以
     */
    final public void excet(){
        this.start();
        this.stop();
    }

}
