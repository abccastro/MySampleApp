/**
 * Component: allows Spring to detect custom beans automatically;
 *      instantiate the class and inject any specified dependencies into it
 * Primary: indicate the primary bean when there are multiple beans of same type
 * Scope: specify the scope of the bean
 * PostConstruct: executed after dependency injection is done to perform any initialization logic
 * PreDestroy: method to be invoked before destroying a bean
 */
package com.metamorph.spring.mysampleapp.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @PostConstruct
    public void init(){
        System.out.println("In init(): " + getClass().getSimpleName());
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("In cleanup(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
