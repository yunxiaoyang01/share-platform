package com.file.share.platform.model;

import javax.persistence.*;

public class Answer {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 试卷id
     */
    @Column(name = "subject_id")
    private Integer subjectId;

    /**
     * 问题id
     */
    private Integer question;

    /**
     * 问题类型
     */
    @Column(name = "question_type")
    private Integer questionType;

    /**
     * 选择的答案
     */
    private String answer;

    /**
     * 正确答案
     */
    @Column(name = "good_answer")
    private String goodAnswer;

    /**
     * 得分
     */
    private Integer score;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取试卷id
     *
     * @return subject_id - 试卷id
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * 设置试卷id
     *
     * @param subjectId 试卷id
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 获取问题id
     *
     * @return question - 问题id
     */
    public Integer getQuestion() {
        return question;
    }

    /**
     * 设置问题id
     *
     * @param question 问题id
     */
    public void setQuestion(Integer question) {
        this.question = question;
    }

    /**
     * 获取问题类型
     *
     * @return question_type - 问题类型
     */
    public Integer getQuestionType() {
        return questionType;
    }

    /**
     * 设置问题类型
     *
     * @param questionType 问题类型
     */
    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    /**
     * 获取选择的答案
     *
     * @return answer - 选择的答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置选择的答案
     *
     * @param answer 选择的答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取正确答案
     *
     * @return good_answer - 正确答案
     */
    public String getGoodAnswer() {
        return goodAnswer;
    }

    /**
     * 设置正确答案
     *
     * @param goodAnswer 正确答案
     */
    public void setGoodAnswer(String goodAnswer) {
        this.goodAnswer = goodAnswer;
    }

    /**
     * 获取得分
     *
     * @return score - 得分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置得分
     *
     * @param score 得分
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}