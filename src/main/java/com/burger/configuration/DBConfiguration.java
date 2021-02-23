package com.burger.configuration;

import com.burger.Application;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration // configuration이 있는 파일을 자바 기반의 설정 파일로 인식한다.
@PropertySource("classpath:/application.properties")
public class DBConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DBConfiguration.class);

    private final ApplicationContext applicationContext;

    public DBConfiguration(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    // hikari connection pool 생성
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    // connection pool을 지원하기 위한 인터페이스인 datasource 생성
    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new HikariDataSource(hikariConfig());
        log.info("datasource : {}", dataSource);
        return dataSource;
    }

    // mybatis와 spring의 연동모듈
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
		factoryBean.setMapperLocations(applicationContext.getResources("classpath*:/query.xml"));
        return factoryBean.getObject();
    }

    // sqlsession 객체 생성
    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

}
