package com.file.share.platform.model.response;

import com.file.share.platform.model.Subject;
import lombok.Data;

@Data
public class SubjectResp extends Subject {

    private String courseName;

    private boolean isExam;
}
