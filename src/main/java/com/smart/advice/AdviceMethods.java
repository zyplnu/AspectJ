package com.smart.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceMethods {

    public void preGreeting(){
        System.out.println("-----how are you!----");
    }

    public void afterReturning(int retVal){

    }

    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint){

    }

    public void afterThrowingMethod(IllegalArgumentException iae){

    }

    public void afterMethod(){

    }

    public void bindParams(int num , String name){
        System.out.println("-------bindParams---------");
        System.out.println("name:" + name);
        System.out.println("num: " + num);
        System.out.println("--------bindParms---------");
    }

}
