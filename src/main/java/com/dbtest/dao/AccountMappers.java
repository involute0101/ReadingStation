package com.dbtest.dao;

import com.dbtest.entity.Account;

public interface AccountMappers {
    public Account selectByAccount(String account);//account为主键
    public void insertAccount(Account a)throws Exception;
}
