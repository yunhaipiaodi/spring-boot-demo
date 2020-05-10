package com.lyn.spring.controller;

import com.lyn.spring.exception.UserNoExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyn
 * @create 2020-05-09 15:59
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNoExistException.class)
    public String handleException(Exception e, HttpServletRequest httpServletRequest){
        Map<String,Object> map  = new HashMap<>();

        httpServletRequest.setAttribute("javax.servlet.error.status_code",400);
        map.put("code","user.no exist");
        map.put("messsage",e.getMessage());
        httpServletRequest.setAttribute("map",map);
        return "forward:/error";
    }
}
