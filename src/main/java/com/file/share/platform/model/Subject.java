package com.file.share.platform.model;

import javax.persistence.*;

public class Subject {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 练习名称
     */
    private String name;

    /**
     * 课程分类
     */
    @Column(name = "course_id")
    private Integer courseId;

    /**
     * 选择题数量
     */
    @Column(name = "choice_num")
    private Integer choiceNum;

    /**
     * 单选题数量
     */
    @Column(name = "judge_num")
    private Integer judgeNum;

    /**
     * 选择题分值
     */
    @Column(name = "choice_score")
    private Integer choiceScore;

    /**
     * 单选题分值
     */
    @Column(name = "judge_score")
    private Integer judgeScore;

    /**
     * 总分
     */
    @Column(name = "all_score")
    private Integer allScore;


    @Column(name="user_id")
    private Integer userId;

    @Column(name = "exam_num")
    private Integer examNum;


    public Integer getExamNum() {
        return examNum;
    }

    public void setExamNum(Integer examNum) {
        this.examNum = examNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
     * 获取练习名称
     *
     * @return name - 练习名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置练习名称
     *
     * @param name 练习名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取课程分类
     *
     * @return course_id - 课程分类
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 设置课程分类
     *
     * @param courseId 课程分类
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取选择题数量
     *
     * @return choice_num - 选择题数量
     */
    public Integer getChoiceNum() {
        return choiceNum;
    }

    /**
     * 设置选择题数量
     *
     * @param choiceNum 选择题数量
     */
    public void setChoiceNum(Integer choiceNum) {
        this.choiceNum = choiceNum;
    }

    /**
     * 获取单选题数量
     *
     * @return judge_num - 单选题数量
     */
    public Integer getJudgeNum() {
        return judgeNum;
    }

    /**
     * 设置单选题数量
     *
     * @param judgeNum 单选题数量
     */
    public void setJudgeNum(Integer judgeNum) {
        this.judgeNum = judgeNum;
    }

    /**
     * 获取选择题分值
     *
     * @return choice_score - 选择题分值
     */
    public Integer getChoiceScore() {
        return choiceScore;
    }

    /**
     * 设置选择题分值
     *
     * @param choiceScore 选择题分值
     */
    public void setChoiceScore(Integer choiceScore) {
        this.choiceScore = choiceScore;
    }

    /**
     * 获取单选题分值
     *
     * @return judge_score - 单选题分值
     */
    public Integer getJudgeScore() {
        return judgeScore;
    }

    /**
     * 设置单选题分值
     *
     * @param judgeScore 单选题分值
     */
    public void setJudgeScore(Integer judgeScore) {
        this.judgeScore = judgeScore;
    }

    /**
     * 获取总分
     *
     * @return all_score - 总分
     */
    public Integer getAllScore() {
        return allScore;
    }

    /**
     * 设置总分
     *
     * @param allScore 总分
     */
    public void setAllScore(Integer allScore) {
        this.allScore = allScore;
    }
}