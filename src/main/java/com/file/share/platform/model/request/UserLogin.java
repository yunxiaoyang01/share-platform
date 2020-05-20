package com.file.share.platform.model.request;

import lombok.Data;

@Data
public class UserLogin {
    private String accountNumber;

    private String password;
}
