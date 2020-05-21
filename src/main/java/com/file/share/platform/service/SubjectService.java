package com.file.share.platform.service;
import com.file.share.platform.model.Subject;
import com.file.share.platform.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
public interface SubjectService extends Service<Subject> {

    List<Subject> findSubjectByCourseId(Integer id);
}
