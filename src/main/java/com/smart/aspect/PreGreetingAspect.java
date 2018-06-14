package com.smart.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 定义一个切面
 */
@Aspect
public class PreGreetingAspect {

    @Before("execution(* greetTo(..))")
    //@AfterReturning("execution(public * *(..))")
    //@AfterReturning("execution(* *To(..))")
    //@AfterReturning("execution(* com.smart.aop.Waiter.*(..))")
    //@AfterReturning("execution(* com.smart.aop.Waiter+.*(..)")
    //@AfterReturning("execution(* com.smart.*(..))")
    //@AfterReturning("execution(* com.smart..*(..))")
    @AfterReturning("execution(* com..*.*Dao.find*(..))")
    public void beforeGreeting(){
        System.out.println("How are you");
    }

}
