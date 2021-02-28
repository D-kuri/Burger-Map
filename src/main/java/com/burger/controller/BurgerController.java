package com.burger.controller;


import com.burger.service.MomsTouchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/map")
public class BurgerController {
    private MomsTouchService momsTouchService;

    public BurgerController(MomsTouchService momsTouchService){
        this.momsTouchService = momsTouchService;
    }

    @PostMapping("/momsTouch.json")
    public Map<String, Object> getMomsTouch(){
        Map<String, Object> momsTouch = new HashMap<>();
        momsTouch.put("momsTouch", momsTouchService.getStores());

        return momsTouch;
    }
}
