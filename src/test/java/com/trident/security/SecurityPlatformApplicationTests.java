package com.trident.security;

import com.github.yitter.idgen.YitIdHelper;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityPlatformApplicationTests {
    
    @Test
    void contextLoads() {
    }
    
    @Ignore
    void generatorSnowId(){
        long newId = YitIdHelper.nextId();
        System.out.println(newId);
        newId = YitIdHelper.nextId();
        System.out.println(newId);
        newId = YitIdHelper.nextId();
        System.out.println(newId);
        newId = YitIdHelper.nextId();
        System.out.println(newId);
    }
    
}
