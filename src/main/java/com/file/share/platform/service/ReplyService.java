package com.file.share.platform.service;
import com.file.share.platform.model.Reply;
import com.file.share.platform.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/24.
 */
public interface ReplyService extends Service<Reply> {

    List<Reply> findByTalkId(Integer talkId);
}
