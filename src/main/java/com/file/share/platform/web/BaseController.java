package com.file.share.platform.web;

import com.file.share.platform.service.*;

import javax.annotation.Resource;

public class BaseController {

    @Resource
    public ChoiceService choiceService;

    @Resource
    public CommentService commentService;

    @Resource
    public CourseService courseService;

    @Resource
    public FileService fileService;

    @Resource
    public JudgeService judgeService;

    @Resource
    public SubjectService subjectService;

    @Resource
    public UserService userService;
}
