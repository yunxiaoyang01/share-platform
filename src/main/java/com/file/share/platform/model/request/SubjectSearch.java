package com.file.share.platform.model.request;

import lombok.Data;

@Data
public class SubjectSearch extends BaseSearch{

    private String name;

    private Integer courseId;

}
