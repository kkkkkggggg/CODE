package com.atck.admin.service.impl;

import com.atck.admin.bean.User;
import com.atck.admin.mapper.UserMapper;
import com.atck.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService
{

}
