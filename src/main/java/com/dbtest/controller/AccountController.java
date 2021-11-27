package com.dbtest.controller;

import com.dbtest.pojo.Account;
import com.dbtest.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RestController("/Account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/createAccount")
    public boolean createAccount(Account account) throws Exception {
        //Account a=new Account(account,name,password,1,false);
        account.setLv(1);account.setVip(false);
        boolean result=accountService.insertAccount(account);
        return result;
    }

    @PostMapping("/assertAccount")
    public boolean assertAccount(Account account) throws IOException {
        return accountService.isPass(account.getAccount(),account.getPassword());
    }
}
