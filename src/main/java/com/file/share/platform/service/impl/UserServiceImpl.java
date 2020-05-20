package com.file.share.platform.service.impl;

import com.file.share.platform.dao.UserMapper;
import com.file.share.platform.model.User;
import com.file.share.platform.service.UserService;
import com.file.share.platform.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findByAccountNumber(String accountNumber) {
        return userMapper.findByAccountNumber(accountNumber);
    }
}
