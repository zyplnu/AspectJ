package com.smart.aspect;

import com.smart.aop.Seller;
import com.smart.aop.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {

    @DeclareParents(value="com.smart.aop.NativeWaiter" , defaultImpl = SmartSeller.class)
    public Seller seller;

}
