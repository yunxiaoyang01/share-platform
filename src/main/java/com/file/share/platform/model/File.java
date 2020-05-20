package com.file.share.platform.model;

import java.util.Date;
import javax.persistence.*;

public class File {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文件名
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 文件地址
     */
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 上传人
     */
    private String uploador;

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
     * 下载量
     */
    @Column(name = "down_num")
    private Integer downNum;

    /**
     * 0视频1音频2图片3文本文件
     */
    @Column(name = "file_type")
    private Integer fileType;

    /**
     * 文件简介
     */
    @Column(name = "file_note")
    private String fileNote;

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
     * 获取文件名
     *
     * @return file_name - 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名
     *
     * @param fileName 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取文件地址
     *
     * @return file_url - 文件地址
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 设置文件地址
     *
     * @param fileUrl 文件地址
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取上传人
     *
     * @return uploador - 上传人
     */
    public String getUploador() {
        return uploador;
    }

    /**
     * 设置上传人
     *
     * @param uploador 上传人
     */
    public void setUploador(String uploador) {
        this.uploador = uploador;
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
     * 获取下载量
     *
     * @return down_num - 下载量
     */
    public Integer getDownNum() {
        return downNum;
    }

    /**
     * 设置下载量
     *
     * @param downNum 下载量
     */
    public void setDownNum(Integer downNum) {
        this.downNum = downNum;
    }

    /**
     * 获取0视频1音频2图片3文本文件
     *
     * @return file_type - 0视频1音频2图片3文本文件
     */
    public Integer getFileType() {
        return fileType;
    }

    /**
     * 设置0视频1音频2图片3文本文件
     *
     * @param fileType 0视频1音频2图片3文本文件
     */
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取文件简介
     *
     * @return file_note - 文件简介
     */
    public String getFileNote() {
        return fileNote;
    }

    /**
     * 设置文件简介
     *
     * @param fileNote 文件简介
     */
    public void setFileNote(String fileNote) {
        this.fileNote = fileNote;
    }
}