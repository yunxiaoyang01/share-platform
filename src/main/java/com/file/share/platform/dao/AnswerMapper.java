package com.file.share.platform.dao;

import com.file.share.platform.core.Mapper;
import com.file.share.platform.model.Answer;

public interface AnswerMapper extends Mapper<Answer> {

    Answer getAnswer(Integer userId, Integer subjectId, Integer question, int questionType);
}