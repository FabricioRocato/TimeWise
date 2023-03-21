package com.example.timewise;

import com.example.timewise.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class TimeWiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeWiseApplication.class, args);
    }

}