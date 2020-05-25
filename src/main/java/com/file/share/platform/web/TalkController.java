package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.Reply;
import com.file.share.platform.model.Talk;
import com.file.share.platform.model.User;
import com.file.share.platform.model.request.BaseSearch;
import com.file.share.platform.model.response.TalkListResp;
import com.file.share.platform.service.TalkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/24.
*/
@RestController
@RequestMapping("/talk")
public class TalkController extends BaseController {

    @PostMapping("/add")
    public Result add(@RequestBody Talk talk, HttpServletRequest request) {
        User user= getUserByToken(request);
        if(user==null){
            return ResultGenerator.genNotLogin();
        }
        talk.setUserId(user.getId());
        talk.setCreateTime(new Date());
        talkService.save(talk);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        talkService.deleteById(id);
        List<Reply> replies = replyService.findByTalkId(id);
        if (replies!=null&&replies.size()>0){
            String ids = "";
            for(Reply reply:replies){
                ids+=reply.getId().toString()+",";
            }
            if(ids.endsWith(",")){
                ids = ids.substring(0,ids.length()-1);
            }
            replyService.deleteByIds(ids);
        }
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Talk talk) {
        talkService.update(talk);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Talk talk = talkService.findById(id);
        return ResultGenerator.genSuccessResult(talk);
    }

    @PostMapping("/list")
    public Result list(@RequestBody BaseSearch baseSearch,HttpServletRequest request) {
        User user = getUserByToken(request);
        if (user==null){
            return ResultGenerator.genNotLogin();
        }
        PageHelper.startPage(baseSearch.getPage(), baseSearch.getSize());
        List<Talk> list  = talkService.findAll();
        List<TalkListResp> result = new ArrayList<>();
        for(Talk talk:list){
            TalkListResp talkListResp = new TalkListResp();
            BeanUtils.copyProperties(talk,talkListResp);
            List<Reply> replies = replyService.findByTalkId(talk.getId());
            talkListResp.setReplyNum(replies==null||replies.size()==0?0:replies.size());
            talkListResp.setMine(false);
            User talkUser = userService.findById(talk.getUserId());
            talkListResp.setUserName(talkUser.getUserName());
            if(user.getRole().equals("admin")){
                talkListResp.setMine(true);
            }
            if(user.getId().equals(talk.getUserId())){
                talkListResp.setMine(true);
            }
            result.add(talkListResp);
        }
        PageInfo pageInfo = new PageInfo(result);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
