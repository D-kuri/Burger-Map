package com.burger.mapper;

import com.burger.domain.BurgerKing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BurgerKingMapper {
    public List<BurgerKing> getBurgerKing();
}
