package com.file.share.platform.service;
import com.file.share.platform.model.Comment;
import com.file.share.platform.core.Service;
import com.file.share.platform.model.User;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
public interface CommentService extends Service<Comment> {

    void saveComment(Comment comment, User user);
}
