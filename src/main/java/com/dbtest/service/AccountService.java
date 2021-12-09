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

    /**
     * 判断密码和账号是否匹配
     *
     * @param account  账号
     * @param password 密码
     * @return
     * @throws IOException
     */
    public boolean isPass(String account, String password) throws IOException {

        try (SqlSession sqlSession = mybatisSqlSessionFactory.openSession()) {
            AccountMappers accountMappers = sqlSession.getMapper(AccountMappers.class);
            Account account1 = accountMappers.selectByAccount(account);
            if (account1 == null)
                return false;
            return account1.getPassword().equals(password);
        }
    }

    public boolean isContained(String account) throws IOException {
        try (SqlSession sqlSession = mybatisSqlSessionFactory.openSession()) {
            AccountMappers accountMappers = sqlSession.getMapper(AccountMappers.class);
            Account account1 = accountMappers.selectByAccount(account);
            if (account1 == null)
                return false;
            return true;
        }
    }

    public boolean insertAccount(Account a) throws Exception {

        try (SqlSession sqlSession = mybatisSqlSessionFactory.openSession(true)) {//打开自动提交
            AccountMappers accountMappers = sqlSession.getMapper(AccountMappers.class);
            accountMappers.insertAccount(a.getAccount(), a.getPassword(), a.getName(), a.getLv(), a.getVip());
            return true;
        }
    }
}
