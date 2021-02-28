package com.burger.service;

import com.burger.domain.GeoCoder;
import com.burger.domain.McDonalds;
import com.burger.mapper.McDonaldsMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class McDonaldsService implements BurgerStore {
    private final SqlSession sqlSession;

    public McDonaldsService(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public List<GeoCoder> getStores() {
        List<McDonalds> mcDonalds = sqlSession.getMapper(McDonaldsMapper.class).getMcDonalds();

        return mcDonalds.stream()
                .map(mcDonald -> GeoCoder.of(mcDonald.getAddress()))
                .collect(Collectors.toList());
    }
}
