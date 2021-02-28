package com.burger.service;

import com.burger.domain.GeoCoder;
import com.burger.domain.Lotteria;
import com.burger.mapper.LotteriaMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LotteriaService implements BurgerStore{
    private final SqlSession sqlSession;

    public LotteriaService(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public List<GeoCoder> getStores() {
        List<Lotteria> lotterias = sqlSession.getMapper(LotteriaMapper.class).getLotteria();

        return lotterias.stream()
                .map(lotteria -> GeoCoder.of(lotteria.getAddress()))
                .collect(Collectors.toList());
    }
}
