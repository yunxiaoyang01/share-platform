package com.file.share.platform.service;
import com.file.share.platform.model.User;
import com.file.share.platform.core.Service;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
public interface UserService extends Service<User> {

    User findByAccountNumber(String accountNumber);
}
