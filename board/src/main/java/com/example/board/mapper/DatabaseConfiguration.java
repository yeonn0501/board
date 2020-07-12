package com.example.board.mapper;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Bean
    public DriverManagerDataSource dataSource() throws SQLException {
        DriverManagerDataSource source = new DriverManagerDataSource();
//        source.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // 자바 설정으로 쓸 때에는 url에 &을 &amp; 로 치환하면 에러     
        source.setUrl("jdbc:log4jdbc:mariadb://112.216.251.11:24306/VIVICLOUD");
        source.setUsername("vivicloud");
        source.setPassword("pAssWord12#");
        return source;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        //sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/config/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.board.dto");
        return sqlSessionFactoryBean.getObject();
    }
    
    
    @Bean
    public SqlSession sqlSession() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate;
    }
    
}
