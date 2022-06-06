/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/5/21
 * Time: 23:06
 **/
package com.trident.security.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class CommonPageController {
    
    @GetMapping("/test")
    public ModelAndView testPage(){
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("test","hello thymeleaf");
        return modelAndView;
    }
    
    @GetMapping("/")
    public ModelAndView indexPage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    
    @GetMapping("/dashboard")
    public ModelAndView dashboardPage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    
    
}
