package com.radoslaw.dauksza.travelers.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EventServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventServiceApplication.class, args);
    }

}
