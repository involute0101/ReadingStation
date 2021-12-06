package com.dbtest.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@CrossOrigin(origins = {"http://localhost:8080", "null"})
@RequestMapping("/user")
public class WebController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 登录的GET方法
     *
     * @return
     */
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    /**
     * 登录的POST方法
     *
     * @param id
     * @param password
     * @param httpSession
     * @return
     */
    //toDo:请做一下index的页面

}
