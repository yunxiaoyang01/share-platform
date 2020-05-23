package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.*;
import com.file.share.platform.model.request.SubjectSearch;
import com.file.share.platform.model.response.ChoiceResp;
import com.file.share.platform.model.response.JudgeResp;
import com.file.share.platform.model.response.QuestionResponse;
import com.file.share.platform.model.response.SubjectResp;
import com.file.share.platform.service.SubjectService;
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
@RequestMapping("/subject")
public class SubjectController extends BaseController{

    @PostMapping("/add")
    public Result add(@RequestBody Subject subject, HttpServletRequest request) {
        User user = getUserByToken(request);
        if (user==null){
            return ResultGenerator.genNotLogin();
        }
        subject.setUserId(user.getId());
        subjectService.save(subject);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        subjectService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Subject subject) {
        subjectService.update(subject);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Subject subject = subjectService.findById(id);
        return ResultGenerator.genSuccessResult(subject);
    }

    @PostMapping("/list")
    public Result list(@RequestBody SubjectSearch subjectSearch,HttpServletRequest request) {
        User user = getUserByToken(request);
        if (user==null){
            return ResultGenerator.genNotLogin();
        }
        PageHelper.startPage(subjectSearch.getPage(), subjectSearch.getSize());
        Condition condition = new Condition(Subject.class);
        Example.Criteria criteria = condition.createCriteria();
        if (user.getRole().equals("teacher")){
            criteria.andEqualTo("userId",user.getId());
        }
        if (subjectSearch.getName()!=null&&!subjectSearch.getName().equals("")){
            criteria.andLike("name","%"+subjectSearch.getName()+"%");
        }
        if (subjectSearch.getCourseId()!=null&&subjectSearch.getCourseId()>0){
            criteria.andEqualTo("courseId",subjectSearch.getCourseId());
        }
        condition.orderBy("id").desc();
        List<Subject> list = subjectService.findByCondition(condition);
        List<SubjectResp> result = new ArrayList<>();
        for(Subject subject:list){
            SubjectResp subjectResp = new SubjectResp();
            BeanUtils.copyProperties(subject,subjectResp);
            Course course = courseService.findById(subject.getCourseId());
            Score score = scoreService.findScoreByCondition(subject.getId(),user.getId());
            if (score!=null){
                subjectResp.setExam(true);
            }
            subjectResp.setExam(false);
            subjectResp.setCourseName(course.getCourseName());
            result.add(subjectResp);
        }
        PageInfo pageInfo = new PageInfo(result);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/questionList")
    public Result questionList(@RequestParam(value = "subject_id") Integer subjectId){
        Subject subject = subjectService.findById(subjectId);
        List<Choice> choices = choiceService.findListBySubjectId(subjectId);
        List<Judge> judges = judgeService.findListBySubjectId(subjectId);
        QuestionResponse questionResponse = new QuestionResponse();
        BeanUtils.copyProperties(subject,questionResponse);
        List<ChoiceResp> choiceResps = new ArrayList<>();
        for(Choice choice:choices){
            ChoiceResp choiceResp = new ChoiceResp();
            BeanUtils.copyProperties(choice,choiceResp);
            choiceResp.setQuestionType(1);
            choiceResps.add(choiceResp);
        }
        List<JudgeResp> judgeResps = new ArrayList<>();
        for(Judge judge:judges){
            JudgeResp judgeResp = new JudgeResp();
            BeanUtils.copyProperties(judge,judgeResp);
            judgeResp.setQuestionType(2);
            judgeResps.add(judgeResp);
        }
        questionResponse.setChoices(choiceResps);
        questionResponse.setJudges(judgeResps);
        return ResultGenerator.genSuccessResult(questionResponse);
    }
}
