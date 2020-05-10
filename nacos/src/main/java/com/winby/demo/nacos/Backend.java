package com.winby.demo.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class Backend {

    @RequestMapping("/api")
    public String printDate(String s) {
        return s;
    }

    public static void main(String[] args) {
        SpringApplication.run(Backend.class,
                "--spring.application.name=backend",
                "--server.port=9000"
        );
    }
}
