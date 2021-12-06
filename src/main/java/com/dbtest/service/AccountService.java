package com.dbtest.service;

import com.dbtest.dao.AccountMappers;
import com.dbtest.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@NoArgsConstructor
@Data

@Service
public class AccountService {

    @Autowired
    private SqlSessionFactory mybatisSqlSessionFactory;

    public boolean isPass(String account,String password) throws IOException{//判断密码和账号是否匹配,目前为单线程

        try(SqlSession sqlSession=mybatisSqlSessionFactory.openSession()){
            AccountMappers accountMappers=sqlSession.getMapper(AccountMappers.class);
            Account account1=accountMappers.selectByAccount(account);
            return account1.getPassword().equals(password);
        }
    }

    public boolean insertAccount(Account a) throws Exception {

        try(SqlSession sqlSession=mybatisSqlSessionFactory.openSession()){
            AccountMappers accountMappers=sqlSession.getMapper(AccountMappers.class);
            accountMappers.insertAccount(a);
            return true;
        }
    }
}
