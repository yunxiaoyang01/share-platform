package com.file.share.platform.model;

import java.util.Date;
import javax.persistence.*;

public class Reply {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 问题id
     */
    @Column(name = "talk_id")
    private Integer talkId;

    /**
     * 答复
     */
    private String reply;

    /**
     * 父答复id（评论在问题上的没有父id）
     */
    @Column(name = "parent_id")
    private Integer parentId;

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

    @Column(name = "review_user_id")
    private Integer reviewUserId;


    @Column(name = "b_review_user_id")
    private Integer bReviewUserId;

    public Integer getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(Integer reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public Integer getbReviewUserId() {
        return bReviewUserId;
    }

    public void setbReviewUserId(Integer bReviewUserId) {
        this.bReviewUserId = bReviewUserId;
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
     * 获取问题id
     *
     * @return talk_id - 问题id
     */
    public Integer getTalkId() {
        return talkId;
    }

    /**
     * 设置问题id
     *
     * @param talkId 问题id
     */
    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    /**
     * 获取答复
     *
     * @return reply - 答复
     */
    public String getReply() {
        return reply;
    }

    /**
     * 设置答复
     *
     * @param reply 答复
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    /**
     * 获取父答复id（评论在问题上的没有父id）
     *
     * @return parent_id - 父答复id（评论在问题上的没有父id）
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父答复id（评论在问题上的没有父id）
     *
     * @param parentId 父答复id（评论在问题上的没有父id）
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
}