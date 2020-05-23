package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.Answer;
import com.file.share.platform.model.Score;
import com.file.share.platform.model.User;
import com.file.share.platform.model.request.AnswerReq;
import com.file.share.platform.model.response.ResultScore;
import com.file.share.platform.service.AnswerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/22.
*/
@RestController
@RequestMapping("/answer")
public class AnswerController extends BaseController{


    @PostMapping("/add")
    public Result add(Answer answer) {
        answerService.save(answer);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        answerService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Answer answer) {
        answerService.update(answer);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Answer answer = answerService.findById(id);
        return ResultGenerator.genSuccessResult(answer);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Answer> list = answerService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @PostMapping("/submitAnswer")
    public Result submitAnswer(@RequestBody AnswerReq answerReq, HttpServletRequest request){
        User user = getUserByToken(request);
        if (user==null){
            return ResultGenerator.genNotLogin();
        }
        boolean b = answerService.submitAnswer(answerReq,user);
        if (b){
            ResultScore resultScore = answerService.getResultScore(user.getId(),answerReq.getSubjectId());
            return ResultGenerator.genSuccessResult(resultScore);
        }
        return ResultGenerator.genFailResult("试卷提交失败");
    }
}
