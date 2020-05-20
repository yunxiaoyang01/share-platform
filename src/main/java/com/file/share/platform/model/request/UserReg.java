package com.file.share.platform.model.request;

import com.file.share.platform.model.User;
import lombok.Data;

@Data
public class UserReg extends User {

    private String confirmPassword;
}
