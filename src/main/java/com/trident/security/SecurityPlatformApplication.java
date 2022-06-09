package com.trident.security;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@MapperScan("com.trident.security.dao")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurityPlatformApplication {
    
    public static void main(String[] args) {
        //雪花id初始化
        IdGeneratorOptions options = new IdGeneratorOptions((short) 8);
        YitIdHelper.setIdGenerator(options);
        
        SpringApplication.run(SecurityPlatformApplication.class, args);
    }
    
}
