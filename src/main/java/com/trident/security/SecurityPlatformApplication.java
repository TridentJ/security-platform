package com.trident.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@MapperScan("com.trident.security.dao")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurityPlatformApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SecurityPlatformApplication.class, args);
    }
    
}
