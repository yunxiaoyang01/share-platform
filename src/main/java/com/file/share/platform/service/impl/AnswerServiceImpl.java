package com.file.share.platform.service.impl;

import com.file.share.platform.dao.*;
import com.file.share.platform.model.*;
import com.file.share.platform.model.request.AnswerReq;
import com.file.share.platform.model.response.ChoiceAnswer;
import com.file.share.platform.model.response.JudgeAnswer;
import com.file.share.platform.model.response.ResultScore;
import com.file.share.platform.service.AnswerService;
import com.file.share.platform.core.AbstractService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/22.
 */
@Service
@Transactional
public class AnswerServiceImpl extends AbstractService<Answer> implements AnswerService {
    @Resource
    private AnswerMapper answerMapper;

    @Resource
    private ScoreMapper scoreMapper;

    @Resource
    private SubjectMapper subjectMapper;

    @Resource
    private ChoiceMapper choiceMapper;

    @Resource
    private JudgeMapper judgeMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean submitAnswer(AnswerReq answerReq, User user) {
        boolean b = true;
        Condition scoreCondition = new Condition(Score.class);
        Example.Criteria criteria = scoreCondition.createCriteria();
        criteria.andEqualTo("subjectId",answerReq.getSubjectId());
        criteria.andEqualTo("userId",user.getId());
        List<Score> scoreList = scoreMapper.selectByCondition(scoreCondition);
        if (scoreList!=null&&scoreList.size()>0){
            return false;
        }
        Subject subject = subjectMapper.selectByPrimaryKey(answerReq.getSubjectId());
        try{
            HashMap<String, Answer> splitAnswer = splitAnswer(user.getId(), answerReq.getSubjectId(), answerReq.getAnswer());
            //同时需要统计考试做题的成绩
            //创建一个学生成绩实例
            Score score = new Score();
            score.setSubjectId(answerReq.getSubjectId());
            score.setUserId(user.getId());
            score.setChoiceScore(0);
            score.setJudgeScore(0);
            score.setAllScore(0);


            //得到该套题的所有选择题
            List<Choice> choices = choiceMapper.findListBySubjectId(answerReq.getSubjectId());
            //得到该套题的所有判断题
            List<Judge> judges = judgeMapper.findListBySubjectId(answerReq.getSubjectId());
            //遍历所有的选择题
            for(Choice choice : choices){
                if(splitAnswer.containsKey(choice.getId()+"-1")){
                    Answer answer2 = splitAnswer.get(choice.getId()+"-1");
                    //设置选择题成绩得分
                    score.setChoiceScore(score.getChoiceScore()+answer2.getScore());
                    //添加答案
                    answerMapper.insertSelective(answer2);
                }else{
                    //添加答案
                    Answer an = new Answer();
                    an.setUserId(user.getId());
                    an.setSubjectId(answerReq.getSubjectId());
                    an.setQuestionType(1);//设置为选择题类型
                    an.setQuestion(choice.getId());//设置题目id
                    an.setAnswer("");
                    an.setGoodAnswer(choice.getAnswer());
                    an.setScore(0);
                    //添加答案
                    answerMapper.insertSelective(an);

                }
            }
            //遍历所有的判断题
            for(Judge judge : judges){
                if(splitAnswer.containsKey(judge.getId()+"-2")){
                    Answer answer2 = splitAnswer.get(judge.getId()+"-2");
                    //设置判断题成绩得分
                    score.setJudgeScore(score.getJudgeScore()+answer2.getScore());
                    //添加答案
                    answerMapper.insertSelective(answer2);
                }else{
                    //添加答案
                    Answer an = new Answer();
                    an.setSubjectId(answerReq.getSubjectId());
                    an.setUserId(user.getId());
                    an.setQuestionType(2);//设置为选择题类型
                    an.setQuestion(judge.getId());//设置题目id
                    an.setAnswer("");
                    an.setGoodAnswer(judge.getAnswer());
                    an.setScore(0);
                    //添加答案
                    answerMapper.insertSelective(an);
                }

            }
            //设置总得分，选择加上判断
            score.setAllScore(score.getChoiceScore()+score.getJudgeScore());
            //保存总成绩
            scoreMapper.insertSelective(score);
            subject.setExamNum(subject.getExamNum()==null?1:subject.getExamNum()+1);
            subjectMapper.updateByPrimaryKeySelective(subject);
        }catch (Throwable e1) {
            b = false;
            e1.printStackTrace();
            throw new RuntimeException(e1.getMessage());
        }
        return b;
    }

    @Override
    public ResultScore getResultScore(Integer userId, Integer subjectId) {
        List<ChoiceAnswer> choiceAnswers = new ArrayList<ChoiceAnswer>();
        List<JudgeAnswer> judgeAnswers = new ArrayList<JudgeAnswer>();
        // TODO Auto-generated method stub
        Subject subject = subjectMapper.selectByPrimaryKey(subjectId);
        //得到所有的选择题
        List<Choice> choices = choiceMapper.findListBySubjectId(subjectId);
        //得到所有的判断题
        List<Judge> judges = judgeMapper.findListBySubjectId(subjectId);

        for(Choice choice : choices){
            //遍历所有的选择题,得到对应的答案
            Answer answer = answerMapper.getAnswer(userId,subjectId,choice.getId(),1);
            ChoiceAnswer choiceAnswer = new ChoiceAnswer();
            BeanUtils.copyProperties(choice,choiceAnswer);
            choiceAnswer.setAnswer(answer.getAnswer());
            choiceAnswer.setGoodAnswer(answer.getGoodAnswer());
            if(answer.getAnswer().equals(answer.getGoodAnswer())){
                choiceAnswer.setTrue(true);
            }else{
                choiceAnswer.setTrue(false);
            }
            choiceAnswer.setQuestionType(1);
            choiceAnswers.add(choiceAnswer);//加入集合
        }
        for(Judge judge : judges){
            //遍历所有的判断题,得到对应的答案
            Answer answer = answerMapper.getAnswer(userId,subjectId, judge.getId(),2);
            JudgeAnswer judgeAnswer = new JudgeAnswer();
            BeanUtils.copyProperties(judge,judgeAnswer);
            judgeAnswer.setAnswer(answer.getAnswer());
            judgeAnswer.setGoodAnswer(answer.getGoodAnswer());
            if(answer.getAnswer().equals(answer.getGoodAnswer())){
                judgeAnswer.setTrue(true);
            }else{
                judgeAnswer.setTrue(false);
            }
            judgeAnswer.setQuestionType(2);
            judgeAnswers.add(judgeAnswer);//加入集合
        }
        ResultScore resultScore = new ResultScore();
        BeanUtils.copyProperties(subject,resultScore);
        Course course = courseMapper.selectByPrimaryKey(subject.getCourseId());
        resultScore.setCourseName(course.getCourseName());
        User user = userMapper.selectByPrimaryKey(userId);
        resultScore.setUserName(user.getUserName());
        resultScore.setChoiceAnswers(choiceAnswers);
        resultScore.setJudgeAnswers(judgeAnswers);
        return resultScore;
    }

    public HashMap<String, Answer> splitAnswer(Integer  userId,Integer subjectId,String answer){
        HashMap<String, Answer> map = new HashMap<String, Answer>();
        Subject subjectById = subjectMapper.selectByPrimaryKey(subjectId);	//得到试卷的详细信息
        //分割解析答案字符串
        //得到每一个答案组
        //需要判断一下答案字符串是否为空，为空则不处理
        if(answer==null){
            return map;
        }else if(answer.equals("")){
            return map;
        }
        String[] str = answer.split("-");
        for(String s : str){
            //得到每个答案组的字符串,继续分割
            String ss[] = s.split("_");
            Answer answer2 = new Answer();
            answer2.setQuestion(Integer.parseInt(ss[0]));
            answer2.setQuestionType(Integer.parseInt(ss[1]));
            answer2.setAnswer(ss[2]);
            answer2.setUserId(userId);
            answer2.setSubjectId(subjectId);
            if(answer2.getQuestionType()==1){
                //选择题
                answer2.setScore(subjectById.getChoiceScore());
                Choice choiceById = choiceMapper.selectByPrimaryKey(answer2.getQuestion());//得到答案
                answer2.setGoodAnswer(choiceById.getAnswer());
                //查看当前的答案与正确答案是否匹配
                if(answer2.getAnswer().equals(answer2.getGoodAnswer())){//判题
                    answer2.setScore(subjectById.getChoiceScore());
                }else{
                    answer2.setScore(0);
                }
            }else{
                //判断题
                answer2.setScore(subjectById.getJudgeScore());
                Judge judgeById = judgeMapper.selectByPrimaryKey(answer2.getQuestion());
                answer2.setGoodAnswer(judgeById.getAnswer());//得到答案
                //查看当前的答案与正确答案是否匹配
                if(answer2.getAnswer().equals(answer2.getGoodAnswer())){//判题
                    answer2.setScore(subjectById.getJudgeScore());
                }else{
                    answer2.setScore(0);
                }
            }
            map.put(answer2.getQuestion()+"-"+answer2.getQuestionType(), answer2);
        }
        return map;
    }
}
