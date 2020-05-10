package com.lyn.spring.controller;

import com.lyn.spring.exception.UserNoExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyn
 * @create 2020-05-05 10:49
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String Hello(@RequestParam("user") String user){
        if("aaa".equals(user)){
            throw new UserNoExistException();
        }
        System.out.println("hello,world!");
        return "dashboard";
    }

}
