package com.file.share.platform.model.response;

import com.file.share.platform.model.Reply;
import lombok.Data;

@Data
public class ReplyResp extends Reply {

    private String reviewUserName;

    private String bReviewUserName;

    private boolean isMine;
}
