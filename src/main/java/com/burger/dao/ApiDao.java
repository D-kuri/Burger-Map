package com.burger.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApiDao {
    protected static final String NAMESPACE = "com.burger.";

    private final SqlSession sqlSession;

    public ApiDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public String select(){
        return sqlSession.selectOne(NAMESPACE + "test");
    }
}
