package com.burger.mapper;

import com.burger.service.MomsTouchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MomsTouchMapperTest{
//    @Autowired
//    private MomsTouchService momsTouchService;
    private MomsTouchService momsTouchService;

    @Autowired
    public MomsTouchMapperTest(MomsTouchService momsTouchService){
        this.momsTouchService = momsTouchService;
    }

    @Test
    public void selectTest(){
        String springVersion = org.springframework.core.SpringVersion.getVersion();

        System.out.println(springVersion);
//        System.out.println(momsTouchService.getStores().get(0).getAddress());
    }
}