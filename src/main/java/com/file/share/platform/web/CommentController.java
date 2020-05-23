package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.Comment;
import com.file.share.platform.model.User;
import com.file.share.platform.model.request.BaseSearch;
import com.file.share.platform.model.request.FileCommentSearch;
import com.file.share.platform.model.response.CommentResp;
import com.file.share.platform.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/20.
*/
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController{


    @PostMapping("/add")
    public Result add(@RequestBody Comment comment, HttpServletRequest request) {
        User user = getUserByToken(request);
        commentService.saveComment(comment,user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        commentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Comment comment) {
        commentService.update(comment);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Comment comment = commentService.findById(id);
        return ResultGenerator.genSuccessResult(comment);
    }

    @PostMapping("/list")
    public Result list(@RequestBody FileCommentSearch baseSearch) {
        PageHelper.startPage(baseSearch.getPage(), baseSearch.getSize());
        Condition condition = new Condition(Comment.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("fileId",baseSearch.getFileId());
        condition.orderBy("createTime").desc();
        List<Comment> list = commentService.findByCondition(condition);
        List<CommentResp> result = new ArrayList<>();
        for(Comment comment:list){
            CommentResp commentResp = new CommentResp();
            BeanUtils.copyProperties(comment,commentResp);
            User reviewUser = userService.findById(commentResp.getReviewUserId());
            commentResp.setReviewUserName(reviewUser.getUserName());
            if (commentResp.getBReviewUserId()!=null&&commentResp.getBReviewUserId()>0){
                User bReviewUser = userService.findById(commentResp.getBReviewUserId());
                commentResp.setBReviewUserName(bReviewUser.getUserName());
            }
            result.add(commentResp);
        }
        PageInfo pageInfo = new PageInfo(result);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
