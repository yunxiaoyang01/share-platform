package com.file.share.platform.dao;

import com.file.share.platform.core.Mapper;
import com.file.share.platform.model.Comment;

import java.util.List;

public interface CommentMapper extends Mapper<Comment> {
    List<Comment> findCommentByParentId(Integer parentId);
}