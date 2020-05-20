package com.file.share.platform.model;

import java.util.Date;
import javax.persistence.*;

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
    @Column(name = "item_id")
    private String itemId;

    /**
     * 订单号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 匿名
     */
    private Boolean anonymous;

    /**
     * 用户Id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 属性1
     */
    private String attribute1;

    /**
     * 属性2
     */
    private String attribute2;

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
     * 商品名称
     */
    @Column(name = "item_title")
    private String itemTitle;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 修改人
     */
    private String updator;

    /**
     * 是否为自动评论
     */
    @Column(name = "is_auto_comment")
    private Byte isAutoComment;

    /**
     * 文字评论
     */
    private String info;

    /**
     * 图片评论
     */
    @Column(name = "info_photo")
    private String infoPhoto;

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
     * 获取商品号
     *
     * @return item_id - 商品号
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 设置商品号
     *
     * @param itemId 商品号
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取订单号
     *
     * @return order_id - 订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单号
     *
     * @param orderId 订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取匿名
     *
     * @return anonymous - 匿名
     */
    public Boolean getAnonymous() {
        return anonymous;
    }

    /**
     * 设置匿名
     *
     * @param anonymous 匿名
     */
    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    /**
     * 获取用户Id
     *
     * @return user_id - 用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取属性1
     *
     * @return attribute1 - 属性1
     */
    public String getAttribute1() {
        return attribute1;
    }

    /**
     * 设置属性1
     *
     * @param attribute1 属性1
     */
    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    /**
     * 获取属性2
     *
     * @return attribute2 - 属性2
     */
    public String getAttribute2() {
        return attribute2;
    }

    /**
     * 设置属性2
     *
     * @param attribute2 属性2
     */
    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
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
     * 获取商品名称
     *
     * @return item_title - 商品名称
     */
    public String getItemTitle() {
        return itemTitle;
    }

    /**
     * 设置商品名称
     *
     * @param itemTitle 商品名称
     */
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取修改人
     *
     * @return updator - 修改人
     */
    public String getUpdator() {
        return updator;
    }

    /**
     * 设置修改人
     *
     * @param updator 修改人
     */
    public void setUpdator(String updator) {
        this.updator = updator;
    }

    /**
     * 获取是否为自动评论
     *
     * @return is_auto_comment - 是否为自动评论
     */
    public Byte getIsAutoComment() {
        return isAutoComment;
    }

    /**
     * 设置是否为自动评论
     *
     * @param isAutoComment 是否为自动评论
     */
    public void setIsAutoComment(Byte isAutoComment) {
        this.isAutoComment = isAutoComment;
    }

    /**
     * 获取文字评论
     *
     * @return info - 文字评论
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置文字评论
     *
     * @param info 文字评论
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 获取图片评论
     *
     * @return info_photo - 图片评论
     */
    public String getInfoPhoto() {
        return infoPhoto;
    }

    /**
     * 设置图片评论
     *
     * @param infoPhoto 图片评论
     */
    public void setInfoPhoto(String infoPhoto) {
        this.infoPhoto = infoPhoto;
    }
}