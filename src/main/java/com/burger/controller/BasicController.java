package com.burger.controller;

import com.burger.dao.ApiDao;
import com.burger.mapper.MomsTouchMapper;
import com.burger.service.MomsTouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
        System.out.println(momsTouchService.findAll().get(0).getAddress());
        return momsTouchService.findAll().get(0).getAddress();
//         return String.format("%s", apiDao.select());
    }
}
