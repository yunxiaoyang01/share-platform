package com.file.share.platform.dao;

import com.file.share.platform.core.Mapper;
import com.file.share.platform.model.Subject;

import java.util.List;

public interface SubjectMapper extends Mapper<Subject> {
    List<Subject> findSubjectByCourseId(Integer courseId);
}