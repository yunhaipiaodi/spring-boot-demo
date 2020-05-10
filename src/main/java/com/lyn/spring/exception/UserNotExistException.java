package com.lyn.spring.exception;

/**
 * @author 许林
 * @create 2020-05-08-23:45
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在");
    }
}
