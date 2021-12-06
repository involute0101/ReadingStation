package com.dbtest.dao;

import com.dbtest.entity.Account;

public interface AccountMappers {
    public Account selectByAccount(String account);//account为主键
    public void insertAccount(String account,String password,String name,int lv,int vip)throws Exception;
}
