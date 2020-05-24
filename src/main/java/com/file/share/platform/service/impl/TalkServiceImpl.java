package com.file.share.platform.service.impl;

import com.file.share.platform.dao.TalkMapper;
import com.file.share.platform.model.Talk;
import com.file.share.platform.service.TalkService;
import com.file.share.platform.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/24.
 */
@Service
@Transactional
public class TalkServiceImpl extends AbstractService<Talk> implements TalkService {
    @Resource
    private TalkMapper talkMapper;

}
