package com.neo.service.impl;

import com.neo.mapper.UserMapper;
import com.neo.model.User;
import com.neo.service.UserService;
import com.neo.core.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/05/19.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
