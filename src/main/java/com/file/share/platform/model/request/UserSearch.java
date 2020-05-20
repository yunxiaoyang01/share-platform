package com.file.share.platform.model.request;

import lombok.Data;

@Data
public class UserSearch extends BaseSearch {

    private String role;

    private String userName;
}
