package com.burger.service;

import com.burger.domain.BurgerKing;
import com.burger.domain.GeoCoder;
import com.burger.mapper.BurgerKingMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BurgerKingService implements BurgerStore{
    private final SqlSession sqlSession;

    public BurgerKingService(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public List<GeoCoder> getStores() {
        List<BurgerKing> burgerKings = sqlSession.getMapper(BurgerKingMapper.class).getBurgerKing();

        return burgerKings.stream()
                .map(burgerKing -> GeoCoder.of(burgerKing.getAddress()))
                .collect(Collectors.toList());
    }
}
