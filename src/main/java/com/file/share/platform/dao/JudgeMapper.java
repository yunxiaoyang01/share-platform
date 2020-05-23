package com.file.share.platform.dao;

import com.file.share.platform.core.Mapper;
import com.file.share.platform.model.Judge;

import java.util.List;

public interface JudgeMapper extends Mapper<Judge> {
    List<Judge> findListBySubjectId(Integer subjectId);
}