package com.burger.mapper;

import com.burger.domain.MomsTouch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MomsTouchMapper {
    public List<MomsTouch> selectMomsTouch();
}
