/**
 * Qualifier: for multiple dependencies, inject specific one into a class
 */
package com.metamorph.spring.mysampleapp.controller;

import com.metamorph.spring.mysampleapp.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;

    /*@Autowired
    public DemoController(Coach coach) {
        this.coach = coach;
    }*/

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach coach) {
        this.coach = coach;
    }

    /*@Autowired
    public void setCoach(@Qualifier("hockeyCoach") Coach coach) {
        this.coach = coach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.coach.getDailyWorkout();
    }

}
