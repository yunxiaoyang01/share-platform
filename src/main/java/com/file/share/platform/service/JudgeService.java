package com.file.share.platform.service;
import com.file.share.platform.model.Judge;
import com.file.share.platform.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
public interface JudgeService extends Service<Judge> {

    List<Judge> findListBySubjectId(Integer subjectId);
}
