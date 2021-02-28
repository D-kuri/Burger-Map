package com.burger.mapper;

import com.burger.domain.McDonalds;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface McDonaldsMapper {
    public List<McDonalds> getMcDonalds();
}
