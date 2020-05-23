package com.file.share.platform.model.response;

import com.file.share.platform.model.Choice;
import com.file.share.platform.model.Judge;
import com.file.share.platform.model.Subject;
import lombok.Data;

import java.util.List;

@Data
public class QuestionResponse extends Subject {

    private String courseName;

    private String userName;
    private List<ChoiceResp> choices;

    private List<JudgeResp> judges;
}
