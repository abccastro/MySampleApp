package com.metamorph.spring.mysampleapp.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SwimCoach implements Coach {

    public SwimCoach() {
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
        return "Practice fast swimming for 10 minutes.";
    }
}
