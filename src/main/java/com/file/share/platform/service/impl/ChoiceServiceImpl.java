package com.file.share.platform.service.impl;

import com.file.share.platform.dao.ChoiceMapper;
import com.file.share.platform.model.Choice;
import com.file.share.platform.service.ChoiceService;
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
public class ChoiceServiceImpl extends AbstractService<Choice> implements ChoiceService {
    @Resource
    private ChoiceMapper choiceMapper;

    @Override
    public List<Choice> findListBySubjectId(Integer subjectId) {
        return choiceMapper.findListBySubjectId(subjectId);
    }
}
