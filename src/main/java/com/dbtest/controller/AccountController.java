package com.dbtest.controller;

import com.dbtest.entity.Account;
import com.dbtest.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping(value ="/Account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/createAccount")
    @ResponseBody
    public boolean createAccount(@RequestBody Account account) throws Exception {//测试通过
        account.setLv(1);account.setVip(0);
        if(accountService.isContained(account.getAccount()))
            return false;//toDo:前端给点提示
        boolean result=accountService.insertAccount(account);
        return result;
    }
    @PostMapping("/assertAccount")
    @ResponseBody
    public boolean assertAccount(@RequestBody Account account) throws IOException {//测试通过
        return accountService.isPass(account.getAccount(),account.getPassword());
    }
}
