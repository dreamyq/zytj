package com.zmql.zytj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username ,@RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
        if (username.equals("admin")&&"123456".equals(password)) {
            session.setAttribute("user", username);
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            return "enter";
        }
    }

    @RequestMapping("enter")
    public String enterSys(){
        return "login";
    }
}
