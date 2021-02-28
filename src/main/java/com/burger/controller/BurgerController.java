package com.burger.controller;


import com.burger.service.BurgerKingService;
import com.burger.service.LotteriaService;
import com.burger.service.McDonaldsService;
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
    private BurgerKingService burgerKingService;
    private LotteriaService lotteriaService;
    private McDonaldsService mcDonaldsService;

    public BurgerController(MomsTouchService momsTouchService,
                            BurgerKingService burgerKingService,
                            LotteriaService lotteriaService,
                            McDonaldsService mcDonaldsService){
        this.momsTouchService = momsTouchService;
        this.burgerKingService = burgerKingService;
        this.lotteriaService = lotteriaService;
        this.mcDonaldsService = mcDonaldsService;
    }


    @PostMapping("/burgerKing.json")
    public Map<String, Object> getBurgerKing(){
        Map<String, Object> burgerKing = new HashMap<>();
        burgerKing.put("burgerKing", burgerKingService.getStores());

        return burgerKing;
    }

    @PostMapping("/momsTouch.json")
    public Map<String, Object> getMomsTouch(){
        Map<String, Object> momsTouch = new HashMap<>();
        momsTouch.put("momsTouch", momsTouchService.getStores());

        return momsTouch;
    }

    @PostMapping("/lotteria.json")
    public Map<String, Object> getLotteria(){
        Map<String, Object> lotteria = new HashMap<>();
        lotteria.put("lotteria", lotteriaService.getStores());

        return lotteria;
    }

    @PostMapping("/mcDonalds.json")
    public Map<String, Object> getMcDonalds(){
        Map<String, Object> mcDonalds = new HashMap<>();
        mcDonalds.put("mcDonalds", mcDonaldsService.getStores());

        return mcDonalds;
    }

}
