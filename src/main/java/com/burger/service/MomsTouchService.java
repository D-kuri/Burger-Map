package com.burger.service;

import com.burger.domain.GeoCoder;
import com.burger.domain.MomsTouch;
import com.burger.mapper.MomsTouchMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MomsTouchService implements BurgerStore {
    private final SqlSession sqlSession;

    public MomsTouchService(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public List<GeoCoder> getStores() {
        List<MomsTouch> momsTouches = sqlSession.getMapper(MomsTouchMapper.class).getMomsTouch();

        return momsTouches.stream()
                .map(momsTouch -> GeoCoder.of(momsTouch.getAddress()))
                .collect(Collectors.toList());
//        return sqlSession.getMapper(MomsTouchMapper.class).selectMomsTouch();
    }

//    {"documents":
//        [{"address":
//            {"address_name":"부산 금정구 장전동 40",
//            "b_code":"2641010800",
//            "h_code":"2641061000",
//            "main_address_no":"40",
//            "mountain_yn":"N",
//            "region_1depth_name":"부산",
//            "region_2depth_name":"금정구",
//            "region_3depth_h_name":"장전2동",
//            "region_3depth_name":"장전동",
//            "sub_address_no":"",
//            "x":"129.08382445362",
//            "y":"35.2322427971605"}
//        }]
//    }
}


//@Service
//public class MomsTouchService {
//    private final SqlSession sqlSession;
//
//    public MomsTouchService(SqlSession sqlSession){
//        this.sqlSession = sqlSession;
//    }
//
//    public List<MomsTouch> findAll(){
//        return sqlSession.getMapper(MomsTouchMapper.class).selectMomsTouch();
//    }
//}