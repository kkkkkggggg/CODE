package com.atck.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "用户被拒绝登录",value = HttpStatus.NOT_ACCEPTABLE)
public class UsernameNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
}
