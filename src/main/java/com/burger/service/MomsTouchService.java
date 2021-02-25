package com.burger.service;

import com.burger.domain.MomsTouch;
import com.burger.mapper.MomsTouchMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomsTouchService {
    private final SqlSession sqlSession;

    public MomsTouchService(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public List<MomsTouch> findAll(){
        return sqlSession.getMapper(MomsTouchMapper.class).selectMomsTouch();
    }


}
