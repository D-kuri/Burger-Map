package com.burger.controller;

import com.burger.service.MomsTouchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController {

    private MomsTouchService momsTouchService;

//    private final ApiDao apiDao;
//
//    public BasicController(ApiDao apiDao){
//        this.apiDao = apiDao;
//    }

    public BasicController(MomsTouchService momsTouchService){
        this.momsTouchService = momsTouchService;
    }

    @GetMapping("/")
    public String helloWorld(){
        return "burger/map";
        //        return momsTouchService.getStores().get(0).getAddress();
//         return String.format("%s", apiDao.select());
    }

    @GetMapping("/index.html")
    public ModelAndView abc(){
        ModelAndView mav = new ModelAndView("map");
        return mav;
    }

    @GetMapping("/test")
    public String a(){
        return "map";
    }
}
