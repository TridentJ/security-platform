/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/5/24
 * Time: 23:51
 **/
package com.trident.security.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

@SpringBootApplication
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
public class SwaggerBootstrapUi implements WebMvcConfigurer {
    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
    }
}
