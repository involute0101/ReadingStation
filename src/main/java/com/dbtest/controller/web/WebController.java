package com.dbtest.controller.web;

import com.dbtest.controller.AccountController;
import com.dbtest.entity.Account;
import com.dbtest.vo.LoginResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@CrossOrigin(origins = {"http://localhost:9000", "null"})
@RequestMapping("/student")
public class WebController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountController accountController;

    /**
     * 登录页面
     */
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    /**
     * 登录页面
     */
    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }

    /**
     * 登录页面
     */
    @GetMapping(value = "/error404")
    public String error(@RequestParam String message) {
        return "error404";
    }

    /**
     * 主页
     * @return
     */
    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/search")
    public String searchWeb(@RequestParam String searchContent){
        return "search";
    }

    @GetMapping(value = "/book")
    public String bookWeb(@RequestParam String bookName){
        return "book";
    }

    /**
     * 登录的POST方法
     */
    @PostMapping(value = "/userLogin")
    @ResponseBody
    public LoginResult userLogin(@RequestParam Map<String, Object> params) {
        try {
            Account account = new Account();
            account.setAccount((String) params.get("account"));
            account.setPassword((String) params.get("password"));
            if (!accountController.assertAccount(account)) {
                return LoginResult.fail("invalid user");
            }
            return LoginResult.success();
        } catch (IOException e) {
            return LoginResult.fail("invalid user");
        }
    }

    @GetMapping("/uploads")
    public String uploadPage() {
        return "upload";
    }

}
