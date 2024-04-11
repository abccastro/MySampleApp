package com.metamorph.spring.mysampleapp.aspect;

import com.metamorph.spring.mysampleapp.entity.Student;
import org.apache.juli.logging.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

// class on related advices for logging
@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Before("com.metamorph.spring.mysampleapp.aspect.AOPDeclarations.forDaoPackageNoGetterSetter()")
    public void beforeDAOAdvice(JoinPoint joinPoint) {
        logger.info("======>>>> Executing @Before advice on DAO methods");

        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();

        // display method signature
        logger.info("Method: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for(Object tempArg : args) {
            logger.info("Record ID: " + tempArg);
        }
    }

    // NOTE: Only works on successful returns / code execution
    @AfterReturning(
            pointcut = "com.metamorph.spring.mysampleapp.aspect.AOPDeclarations.forSaveMethod()",
            returning = "result")
    public void afterReturningdSaveAdvice(JoinPoint joinPoint, Student result) {
        logger.info("======>>>> Executing @AfterReturning advice on DAO methods");
        logger.info("Method: " + joinPoint.getSignature().toShortString());
        logger.info("Result: " + result);

        // to update result value
//        result.setLastName("Concepcion");
//        logger.info("Updated Result: " + result);
    }


    // NOTE: Exception will still be propagated to the caller method
    @AfterThrowing(
            pointcut = "com.metamorph.spring.mysampleapp.aspect.AOPDeclarations.forSaveMethod()",
            throwing = "exception")
    public void afterThrowingSaveAdvice(JoinPoint joinPoint, Throwable exception) {
        logger.info("======>>>> Executing @AfterThrowing advice on DAO methods");
        logger.info("Method: " + joinPoint.getSignature().toShortString());
        logger.info("Exception: " + exception);
    }

    // NOTE: Will be executed regardless of the result (whether success or failure)
    @After("com.metamorph.spring.mysampleapp.aspect.AOPDeclarations.forSaveMethod()")
    public void afterFinallySaveAdvice(JoinPoint joinPoint) {
        logger.info("======>>>> Executing @After advice on DAO methods");
        logger.info("Method: " + joinPoint.getSignature().toShortString());
    }

    // NOTE: Acts as @Before and @After aspect. Can stop exception propagation.
    @Around("com.metamorph.spring.mysampleapp.aspect.AOPDeclarations.forSaveMethod()")
    public Object aroundSaveAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("======>>>> Executing @Around advice on DAO methods");
        logger.info("Method: " + proceedingJoinPoint.getSignature().toShortString());

        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        // compute the duration the method completed the process
        long duration = end - begin;
        logger.info("Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

}
