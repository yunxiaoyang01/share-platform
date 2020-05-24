package com.file.share.platform.dao;

import com.file.share.platform.core.Mapper;
import com.file.share.platform.model.Reply;

import java.util.List;

public interface ReplyMapper extends Mapper<Reply> {
    List<Reply> findByTalkId(Integer talkId);
}