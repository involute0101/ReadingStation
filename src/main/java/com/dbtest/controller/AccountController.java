package com.dbtest.controller;

import com.dbtest.entity.Account;
import com.dbtest.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/Account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    @ResponseBody
    public void createAccount(@RequestPart String userName, @RequestPart String password, @RequestPart String email,
                              HttpServletResponse response) throws Exception {
        Account account = new Account(userName, null, password, email, 1, 0);
        if (accountService.isContained(account.getAccount())) {
            response.sendRedirect("/student/error404?message=Account exist!");
            return;
        }
        boolean result = accountService.insertAccount(account);
        if (!result) {
            response.sendRedirect("/student/error404?message=Server Error");
            return;
        }
        response.sendRedirect("/student/index");
    }

    @PostMapping("/assertAccount")
    @ResponseBody
    public boolean assertAccount(@RequestBody Account account) throws IOException {
        return accountService.isPass(account.getAccount(), account.getPassword());
    }
}
