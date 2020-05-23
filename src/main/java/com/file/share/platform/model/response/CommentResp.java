package com.file.share.platform.model.response;

import com.file.share.platform.model.Comment;
import lombok.Data;

@Data
public class CommentResp extends Comment {

    private String reviewUserName;

    private String bReviewUserName;
}
