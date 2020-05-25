package com.file.share.platform.model.response;

import com.file.share.platform.model.Talk;
import lombok.Data;

@Data
public class TalkListResp extends Talk {

    private Integer replyNum;

    private String userName;

    private boolean isMine;
}
