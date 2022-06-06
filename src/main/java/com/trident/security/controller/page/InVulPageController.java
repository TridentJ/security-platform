/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/5/23
 * Time: 22:37
 **/
package com.trident.security.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class InVulPageController {
    
    @GetMapping("/in-vul-list")
    public ModelAndView inVulListPage(){
        ModelAndView modelAndView = new ModelAndView("in-vul-list");
        return modelAndView;
    }
    
    @GetMapping("/in-vul-add")
    public ModelAndView inVulAddPage(){
        ModelAndView modelAndView = new ModelAndView("in-vul-add");
        return modelAndView;
    }
    
}
