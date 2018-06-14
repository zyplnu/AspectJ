package com.smart.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TestAspect {

    @AfterReturning("@annotation(com.smart.annotation.NeedTest)")
    public void needTestFun(){
        System.out.println("needTestFun() executed!");
    }

    @After("within(com.smart.*)" + " && execution(* greetTo(..))")
    public void greetToFun(){
        System.out.println("--greetToFun() executed!");
    }

    @Before(" !target(com.smart.aop.NativeWaiter) " + "&& execution(* serveTo(..))")
    public void notServeInNativeWaiter(){
        System.out.println("");
    }

    @AfterReturning("target(com.smart.aop.Waiter) || " + " target(com.smart.aop.Seller)")
    public void waiterOnSale(){
        System.out.println("");
    }

    @Before("TestNamePointCut.inPkgGreetTo()")
    public void pkgGreetTo(){
        System.out.println("");
    }

    @Before("!target(com.smart.aop.NativeWaiter) && TestNamePointCut.inPkgGreetTo()")
    public void pkgGreetToNotNativeWaiter(){
        System.out.println("");
    }

    @Around("execution(* greetTo(..)) && target(com.smart.aop.NativeWaiter)")
    public void joinPointAccess(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("--------------joinPointAccess--------------");
        System.out.println("args[0]" + proceedingJoinPoint.getArgs()[0]);
        System.out.println("signature:" + proceedingJoinPoint.getTarget().getClass());
        proceedingJoinPoint.proceed();
        System.out.println("--------------joinPointAccess---------------");
    }
}
