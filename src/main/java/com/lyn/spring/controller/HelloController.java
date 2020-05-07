package com.lyn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyn
 * @create 2020-05-05 10:49
 */
@Controller
public class HelloController {

    @RequestMapping("/test")
    public String index(){
        return "index";
    }


    @RequestMapping("/hello")
    public String Hello(){
        System.out.println("hello,world!");
        return "Hello page";
    }
}
