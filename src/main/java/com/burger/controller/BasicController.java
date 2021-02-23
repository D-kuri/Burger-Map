package com.burger.controller;

import com.burger.dao.ApiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    private final ApiDao apiDao;

    public BasicController(ApiDao apiDao){
        this.apiDao = apiDao;
    }

    @GetMapping("/")
    public String helloWorld(){
        return String.format("%s", apiDao.select());
    }
}
