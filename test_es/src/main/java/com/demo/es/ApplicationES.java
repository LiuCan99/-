package com.demo.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  //开启缓存
public class ApplicationES {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationES.class,args);
    }
}
