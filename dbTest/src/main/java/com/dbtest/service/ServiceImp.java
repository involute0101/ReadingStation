package com.dbtest.service;

import com.dbtest.dao.AccountMappers;
import com.dbtest.pojo.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
@NoArgsConstructor
@Data

public class ServiceImp implements Service{
    String resource="dbConfig.xml";
    @Override
    public boolean isPass(String account,String password) throws IOException{//判断密码和账号是否匹配,目前为单线程
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession=sqlSessionFactory.openSession()){
            AccountMappers accountMappers=sqlSession.getMapper(AccountMappers.class);
            Account account1=accountMappers.selectByAccount(account);
            return account1.isPass(password);
        }
    }

    @Override
    public boolean insertAccount(Account a) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession=sqlSessionFactory.openSession()){
            AccountMappers accountMappers=sqlSession.getMapper(AccountMappers.class);
            accountMappers.insertAccount(a);
            return true;
        }
    }
}
