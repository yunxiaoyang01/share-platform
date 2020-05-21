package com.file.share.platform.service.impl;

import com.file.share.platform.dao.SubjectMapper;
import com.file.share.platform.model.Subject;
import com.file.share.platform.service.SubjectService;
import com.file.share.platform.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
@Service
@Transactional
public class SubjectServiceImpl extends AbstractService<Subject> implements SubjectService {
    @Resource
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> findSubjectByCourseId(Integer courseId) {
        return subjectMapper.findSubjectByCourseId(courseId);
    }
}
