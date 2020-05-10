package com.lyn.spring.exception;

/**
 * @author lyn
 * @create 2020-05-09 13:43
 */
public class UserNoExistException extends RuntimeException{

    public UserNoExistException() {
        super("用户不存在");
    }
}
