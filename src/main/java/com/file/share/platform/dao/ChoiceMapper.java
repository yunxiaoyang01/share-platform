package com.file.share.platform.dao;

import com.file.share.platform.core.Mapper;
import com.file.share.platform.model.Choice;

import java.util.List;

public interface ChoiceMapper extends Mapper<Choice> {
    List<Choice> findListBySubjectId(Integer subjectId);
}