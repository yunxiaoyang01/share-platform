package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.Choice;
import com.file.share.platform.model.Subject;
import com.file.share.platform.service.ChoiceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/20.
*/
@RestController
@RequestMapping("/choice")
public class ChoiceController extends BaseController{


    @PostMapping("/add")
    public Result add(@RequestBody Choice choice) {
        choice.setCreateTime(new Date());
        choiceService.save(choice);
        Subject subject = subjectService.findById(choice.getSubjectId());
        if (subject==null){
            return ResultGenerator.genFailResult("当前试卷不存在");
        }
        subject.setChoiceNum(subject.getChoiceNum()==null?1:subject.getChoiceNum()+1);
        subject.setAllScore(subject.getAllScore()==null?subject.getChoiceScore():(subject.getAllScore()+subject.getChoiceScore()));
        subjectService.update(subject);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        Choice choice = choiceService.findById(id);
        Subject subject = subjectService.findById(choice.getSubjectId());
        choiceService.deleteById(id);
        subject.setChoiceNum(subject.getChoiceNum()-1);
        subject.setAllScore(subject.getAllScore()-subject.getChoiceScore());
        subjectService.update(subject);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Choice choice) {
        choice.setUpdateTime(new Date());
        choiceService.update(choice);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Choice choice = choiceService.findById(id);
        return ResultGenerator.genSuccessResult(choice);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Choice> list = choiceService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
