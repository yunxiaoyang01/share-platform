package com.file.share.platform.service.impl;

import com.file.share.platform.dao.JudgeMapper;
import com.file.share.platform.model.Judge;
import com.file.share.platform.service.JudgeService;
import com.file.share.platform.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
@Service
@Transactional
public class JudgeServiceImpl extends AbstractService<Judge> implements JudgeService {
    @Resource
    private JudgeMapper judgeMapper;

}
