package com.file.share.platform.model.request;

import lombok.Data;

@Data
public class FileSearch extends BaseSearch{

    private Integer courseId;

    private Integer fileType;
}
