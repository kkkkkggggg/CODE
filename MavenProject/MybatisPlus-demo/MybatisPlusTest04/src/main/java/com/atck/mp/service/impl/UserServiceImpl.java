package com.atck.mp.service.impl;

import com.atck.mp.beans.User;
import com.atck.mp.mapper.UserMapper;
import com.atck.mp.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kkkkk
 * @since 2021-09-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
