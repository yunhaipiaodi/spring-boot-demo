package com.lyn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author lyn
 * @create 2020-05-07 14:44
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession httpSession){
        if(!StringUtils.isEmpty(userName) && "123456".equals(password)){
            //登陆成功
            httpSession.setAttribute("userName",userName);
            return "redirect:/main.html";
        }else{
            //登陆失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
