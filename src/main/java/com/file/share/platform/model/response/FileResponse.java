package com.file.share.platform.model.response;

import com.file.share.platform.model.Course;
import com.file.share.platform.model.File;
import lombok.Data;

@Data
public class FileResponse extends File {
    private boolean isMine;

    private String courseName;
}
