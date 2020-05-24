package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.Reply;
import com.file.share.platform.model.User;
import com.file.share.platform.model.request.ReplySearch;
import com.file.share.platform.model.response.ReplyResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/24.
*/
@RestController
@RequestMapping("/reply")
public class ReplyController extends BaseController{

    @PostMapping("/add")
    public Result add(@RequestBody  Reply reply, HttpServletRequest request) {
        User user = getUserByToken(request);
        if(user==null){
            return ResultGenerator.genNotLogin();
        }
        reply.setReviewUserId(user.getId());
        if(reply.getParentId()!=null){
            Reply bReply = replyService.findById(reply.getParentId());
            if(bReply!=null){
                reply.setbReviewUserId(bReply.getReviewUserId());
            }
        }
        replyService.save(reply);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        replyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Reply reply) {
        replyService.update(reply);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Reply reply = replyService.findById(id);
        return ResultGenerator.genSuccessResult(reply);
    }

    @PostMapping("/list")
    public Result list(@RequestBody ReplySearch replySearch) {
        PageHelper.startPage(replySearch.getPage(), replySearch.getSize());
        Condition condition = new Condition(Reply.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("talkId",replySearch.getTalkId());
        condition.orderBy("id").desc();
        List<Reply> list = replyService.findByCondition(condition);
        List<ReplyResp> result = new ArrayList<>();
        for(Reply reply:list){
            ReplyResp replyResp = new ReplyResp();
            BeanUtils.copyProperties(reply,replyResp);
            User user =  userService.findById(reply.getReviewUserId());
            replyResp.setReviewUserName(user.getUserName());
            if(reply.getbReviewUserId()!=null){
                User bUser = userService.findById(reply.getbReviewUserId());
                replyResp.setBReviewUserName(bUser.getUserName());
            }
            result.add(replyResp);
        }
        PageInfo pageInfo = new PageInfo(result);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
