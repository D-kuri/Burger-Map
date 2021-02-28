package com.burger.controller;

import com.burger.service.MomsTouchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    private MomsTouchService momsTouchService;

    public BasicController(MomsTouchService momsTouchService){
        this.momsTouchService = momsTouchService;
    }

    @GetMapping("/")
    public String burgerMap(){
        return "map";
    }

}
