package com.file.share.platform.service;
import com.file.share.platform.model.Choice;
import com.file.share.platform.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
public interface ChoiceService extends Service<Choice> {

    List<Choice> findListBySubjectId(Integer subjectId);
}
