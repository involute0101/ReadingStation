package com.dbtest.service;

import com.dbtest.pojo.Account;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

public interface Service {
    public boolean isPass(String account,String password) throws IOException;
    public boolean insertAccount(Account a)throws IOException, Exception;
}
