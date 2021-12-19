package com.dbtest.dao;

import com.dbtest.entity.Account;

public interface AccountMappers {

    public Account selectByAccount(String account);

    public void insertAccount(Account account)throws Exception;
}
