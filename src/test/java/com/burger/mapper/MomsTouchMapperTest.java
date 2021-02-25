package com.burger.mapper;

import com.burger.ApplicationTest;
import com.burger.service.MomsTouchService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println(momsTouchService.findAll().get(0).getAddress());
    }
}