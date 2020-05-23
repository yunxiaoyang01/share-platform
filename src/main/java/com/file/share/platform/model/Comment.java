package com.file.share.platform.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
public class Comment {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品号
     */
    @Column(name = "content")
    private String content;

    /**
     * 父评论id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     * 评论人id
     */
    @Column(name = "review_user_id")
    private Integer reviewUserId;

    /**
     * 被评论人id
     */
    @Column(name = "b_review_user_id")
    private Integer bReviewUserId;

    /**
     * 资源id
     */
    @Column(name = "file_id")
    private Integer fileId;


}