package com.file.share.platform.model;

import javax.persistence.*;

public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(name = "choice_score")
    private Integer choiceScore;

    @Column(name = "judge_score")
    private Integer judgeScore;

    @Column(name = "all_score")
    private Integer allScore;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return subject_id
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * @return choice_score
     */
    public Integer getChoiceScore() {
        return choiceScore;
    }

    /**
     * @param choiceScore
     */
    public void setChoiceScore(Integer choiceScore) {
        this.choiceScore = choiceScore;
    }

    /**
     * @return judge_score
     */
    public Integer getJudgeScore() {
        return judgeScore;
    }

    /**
     * @param judgeScore
     */
    public void setJudgeScore(Integer judgeScore) {
        this.judgeScore = judgeScore;
    }

    /**
     * @return all_score
     */
    public Integer getAllScore() {
        return allScore;
    }

    /**
     * @param allScore
     */
    public void setAllScore(Integer allScore) {
        this.allScore = allScore;
    }
}