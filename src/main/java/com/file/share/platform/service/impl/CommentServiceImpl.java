package com.file.share.platform.service.impl;

import com.file.share.platform.dao.CommentMapper;
import com.file.share.platform.model.Comment;
import com.file.share.platform.model.User;
import com.file.share.platform.service.CommentService;
import com.file.share.platform.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
@Service
@Transactional
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public void saveComment(Comment comment, User user) {
        if (comment.getParentId()!=null&&comment.getParentId()>0){
            Comment pComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            comment.setBReviewUserId(pComment.getReviewUserId());
        }
        comment.setReviewUserId(user.getId());
        comment.setCreateTime(new Date());
        commentMapper.insert(comment);
    }
}
