package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.Course;
import com.file.share.platform.model.File;
import com.file.share.platform.model.Subject;
import com.file.share.platform.model.User;
import com.file.share.platform.model.request.BaseSearch;
import com.file.share.platform.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/20.
*/
@RestController
@RequestMapping("/course")
public class CourseController extends BaseController{

    @PostMapping("/add")
    public Result add(@RequestBody Course course, HttpServletRequest request) {
        User user = getUserByToken(request);
        if (user==null){
            return ResultGenerator.genNotLogin();
        }
        course.setCreateTime(new Date());
        course.setUpdator(user.getUserName());
        courseService.save(course);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        List<File> files = fileService.findFileByCourseId(id);
        if (files!=null&&files.size()>0){
            return ResultGenerator.genFailResult("当前课程下有共享资源不能删除");
        }
        List<Subject> subjects = subjectService.findSubjectByCourseId(id);
        if (subjects!=null&&subjects.size()>0){
            return ResultGenerator.genFailResult("当前课程下有在线练习题不能删除");
        }
        courseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Course course, HttpServletRequest request) {
        User user = getUserByToken(request);
        if (user==null){
            return ResultGenerator.genNotLogin();
        }
        course.setUpdateTime(new Date());
        course.setUpdator(user.getUserName());
        courseService.update(course);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Course course = courseService.findById(id);
        return ResultGenerator.genSuccessResult(course);
    }

    @PostMapping("/list")
    public Result list(@RequestBody  BaseSearch baseSearch) {
        PageHelper.startPage(baseSearch.getPage(), baseSearch.getSize());
        List<Course> list = courseService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/findAll")
    public Result findAll(){
        List<Course> result = new ArrayList<>();
        Course course = new Course();
        course.setId(0);
        course.setCourseName("全部");
        result.add(course);
        List<Course> list = courseService.findAll();
        result.addAll(list);
        return ResultGenerator.genSuccessResult(result);
    }
}
