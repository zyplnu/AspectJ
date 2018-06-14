package com.smart;

import com.smart.annotation.NeedTest;
import com.smart.aop.NativeWaiter;
import com.smart.aop.Seller;
import com.smart.aop.Waiter;
import com.smart.aspect.PreGreetingAspect;
import com.smart.service.ForumService;
import org.junit.Before;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * 反射测试注解类
 */
public class AnnotationTest {

    @Test
    public void testAnnotation(){
        Class clazz = ForumService.class;
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);

        for(Method mt : methods){
            NeedTest nt = mt.getAnnotation(NeedTest.class);
            if(nt != null){
                if(nt.value()){
                    System.out.println(mt.getName() + "需要测试");
                }else{
                    System.out.println(mt.getName() + "不需要测试");
                }
            }
        }
    }

    @Test
    public void testAspect(){
        Waiter target = new NativeWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();

        factory.setTarget(target);

        factory.addAspect(PreGreetingAspect.class);

        Waiter proxy = factory.getProxy();

        proxy.greetTo("John");

        proxy.serveTo("John");
    }

    @Test
    public void testAspectByXml(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Waiter proxy = (Waiter) ctx.getBean("waiter");
        proxy.greetTo("John");
        Seller seller = (Seller) proxy;
        seller.sell("Beer");
    }

    @Test
    public void testAnnotation2(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Waiter nativeWaiter = (Waiter) ctx.getBean("nativeWaiter");
        Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");
        nativeWaiter.greetTo("John");
        naughtyWaiter.greetTo("John");
    }

    @Test
    public void testJoinpoint(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Waiter nativeWaiter = (Waiter) ctx.getBean("nativeWaiter");
        nativeWaiter.greetTo("John");
    }

    @Test
    public void bindParams(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Waiter nativeWaiter = (Waiter) ctx.getBean("nativeWaiter");
        ((NativeWaiter)nativeWaiter).smile("John" , 2);
    }
}
