package com.lyn.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyn
 * @create 2020-05-05 10:49
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String Hello(){
        System.out.println("hello,world!");
        return "Hello page";
    }
}
