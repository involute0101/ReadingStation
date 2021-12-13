package com.dbtest.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class MybatisConfig {

    @Bean
    public SqlSessionFactory mybatisSqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("dbConfig.xml");
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

}
