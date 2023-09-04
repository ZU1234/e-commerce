package com.facade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.com.core", "com.com.facade"})
public class FacadeApplication {
    public static void main(String[] args) {
        SpringApplication.run(FacadeApplication.class, args);
    }

}


