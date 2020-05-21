package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.Subject;
import com.file.share.platform.model.User;
import com.file.share.platform.service.SubjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        subjectService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Subject subject) {
        subjectService.update(subject);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Subject subject = subjectService.findById(id);
        return ResultGenerator.genSuccessResult(subject);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Subject> list = subjectService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
