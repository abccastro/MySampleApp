package com.metamorph.spring.mysampleapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

// class on related advices for logging
@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Before("com.metamorph.spring.mysampleapp.aspect.AOPDeclarations.forDaoPackageNoGetterSetter()")
    public void logToCloudAdvice(JoinPoint joinPoint) {
        logger.info("======>>>> Cloud logging");
    }
}
