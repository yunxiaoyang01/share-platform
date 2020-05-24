package com.file.share.platform.service.impl;

import com.file.share.platform.dao.ReplyMapper;
import com.file.share.platform.model.Reply;
import com.file.share.platform.service.ReplyService;
import com.file.share.platform.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/24.
 */
@Service
@Transactional
public class ReplyServiceImpl extends AbstractService<Reply> implements ReplyService {
    @Resource
    private ReplyMapper replyMapper;

    @Override
    public List<Reply> findByTalkId(Integer talkId) {
        return replyMapper.findByTalkId(talkId);
    }
}
