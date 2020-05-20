package com.file.share.platform.dao;

import com.file.share.platform.core.Mapper;
import com.file.share.platform.model.User;

public interface UserMapper extends Mapper<User> {
    User findByAccountNumber(String accountNumber);
}