/**
 * Component: allows Spring to detect custom beans automatically;
 *      instantiate the class and inject any specified dependencies into it
 */
package com.metamorph.spring.mysampleapp.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HockeyCoach implements Coach {

    public HockeyCoach() {
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
        return "Practice fast running for 10 minutes.";
    }
}
