package com.dbtest.control;

import com.dbtest.pojo.Account;
import com.dbtest.service.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
@AllArgsConstructor
@NoArgsConstructor
@Data
@RestController("/Account")
public class AccountController {
    @Autowired
    Service service;
    @GetMapping("/createAccount")
    boolean createAccount(String account,String password,String name) throws Exception {
        Account a=new Account(account,name,password,1,false);
        boolean result=service.insertAccount(a);
        return result;
    }
}
