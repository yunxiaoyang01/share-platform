package com.file.share.platform.model;

import java.util.Date;
import javax.persistence.*;

public class Choice {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 问题描述
     */
    private String question;

    /**
     * 选项A
     */
    @Column(name = "optionA")
    private String optiona;

    /**
     * 选项B
     */
    @Column(name = "optionB")
    private String optionb;

    /**
     * 选项C
     */
    @Column(name = "optionC")
    private String optionc;

    /**
     * 选项D
     */
    @Column(name = "optionD")
    private String optiond;

    /**
     * 答案
     */
    private String answer;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 试卷id
     */
    @Column(name = "subject_id")
    private Integer subjectId;

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
     * 获取问题描述
     *
     * @return question - 问题描述
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 设置问题描述
     *
     * @param question 问题描述
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 获取选项A
     *
     * @return optionA - 选项A
     */
    public String getOptiona() {
        return optiona;
    }

    /**
     * 设置选项A
     *
     * @param optiona 选项A
     */
    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    /**
     * 获取选项B
     *
     * @return optionB - 选项B
     */
    public String getOptionb() {
        return optionb;
    }

    /**
     * 设置选项B
     *
     * @param optionb 选项B
     */
    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    /**
     * 获取选项C
     *
     * @return optionC - 选项C
     */
    public String getOptionc() {
        return optionc;
    }

    /**
     * 设置选项C
     *
     * @param optionc 选项C
     */
    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    /**
     * 获取选项D
     *
     * @return optionD - 选项D
     */
    public String getOptiond() {
        return optiond;
    }

    /**
     * 设置选项D
     *
     * @param optiond 选项D
     */
    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    /**
     * 获取答案
     *
     * @return answer - 答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置答案
     *
     * @param answer 答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}