package com.file.share.platform.web;

import com.file.share.platform.model.User;
import com.file.share.platform.service.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Resource
    public AnswerService answerService;

    @Resource
    public ScoreService scoreService;

    @Resource
    public TalkService talkService;

    @Resource
    public ReplyService replyService;

    public User getUserByToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        if(token==null||token.equals("")){
            return null;
        }
        Condition condition = new Condition(User.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("token",token);
        List<User> users = userService.findByCondition(condition);
        if(users==null ||users.size()==0){
            return null;
        }
        return users.get(0);
    }
}
