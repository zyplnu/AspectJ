package com.smart.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class TestNamePointCut {

    @Pointcut("within(com.smart.*)")
    private void inPackage(){}

    @Pointcut("execution(* greetTo(..))")
    protected void greetTo(){}

    @Pointcut("inPackage() && greetTo()")
    public void inPkgGreetTo(){}
}
