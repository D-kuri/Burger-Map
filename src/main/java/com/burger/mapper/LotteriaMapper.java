package com.burger.mapper;

import com.burger.domain.Lotteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LotteriaMapper {
    public List<Lotteria> getLotteria();
}
