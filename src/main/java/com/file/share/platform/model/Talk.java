package com.file.share.platform.model;

import java.util.Date;
import javax.persistence.*;

public class Talk {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 问题
     */
    private String question;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 提出人
     */
    @Column(name = "user_id")
    private Integer userId;

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
     * 获取问题
     *
     * @return question - 问题
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 设置问题
     *
     * @param question 问题
     */
    public void setQuestion(String question) {
        this.question = question;
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
     * 获取提出人
     *
     * @return user_id - 提出人
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置提出人
     *
     * @param userId 提出人
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}