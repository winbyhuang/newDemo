package com.winby.demo;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;


@Log
@SpringBootApplication
//@EnableCaching
public class WebApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(WebApplication.class, args);
        log.info("启动成功------------------");
    }
}
