/**
 * Configuration: mark the class as a source of bean definitions
 *      Bean Definition: specify the objects that SPring will manage
 *          and make available for dependency injection
 * Bean: provides flexibility in creation and configuring beans to customize instantiation
 *      and setup of objects in spring app context
 *
 *      Use Case: third-party class with no access to the codes, only JAR file (e.g. AWS S3)
 */
package com.metamorph.spring.mysampleapp.config;

import com.metamorph.spring.mysampleapp.service.Coach;
import com.metamorph.spring.mysampleapp.service.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swimCoach") // can be changed to another bean ID
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
