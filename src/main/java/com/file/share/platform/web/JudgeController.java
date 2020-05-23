package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.Judge;
import com.file.share.platform.model.Subject;
import com.file.share.platform.model.User;
import com.file.share.platform.service.JudgeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/20.
*/
@RestController
@RequestMapping("/judge")
public class JudgeController extends BaseController{

    @PostMapping("/add")
    public Result add(@RequestBody Judge judge, HttpServletRequest request) {
        User user = getUserByToken(request);
        if (user==null){
            return ResultGenerator.genNotLogin();
        }
        judge.setUpdator(user.getUserName());
        judge.setCreateTime(new Date());
        judgeService.save(judge);
        Subject subject = subjectService.findById(judge.getSubjectId());
        if (subject==null){
            return ResultGenerator.genFailResult("当前试卷不存在");
        }
        subject.setJudgeNum(subject.getJudgeNum()==null?1:subject.getJudgeNum()+1);
        subject.setAllScore(subject.getAllScore()==null?subject.getJudgeScore():(subject.getAllScore()+subject.getJudgeScore()));
        subjectService.update(subject);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        Judge judge = judgeService.findById(id);
        Subject subject = subjectService.findById(judge.getSubjectId());
        judgeService.deleteById(id);
        subject.setJudgeNum(subject.getJudgeNum()-1);
        subject.setAllScore(subject.getAllScore()-subject.getJudgeScore());
        subjectService.update(subject);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Judge judge,HttpServletRequest request) {
        User user = getUserByToken(request);
        if (user==null){
            return ResultGenerator.genNotLogin();
        }
        judge.setUpdator(user.getUserName());
        judge.setCreateTime(new Date());
        judgeService.update(judge);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Judge judge = judgeService.findById(id);
        return ResultGenerator.genSuccessResult(judge);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Judge> list = judgeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
