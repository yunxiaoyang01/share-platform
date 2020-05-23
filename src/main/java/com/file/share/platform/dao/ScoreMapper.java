package com.file.share.platform.dao;

import com.file.share.platform.core.Mapper;
import com.file.share.platform.model.Score;
import com.file.share.platform.model.response.DistributionScore;

import java.util.List;

public interface ScoreMapper extends Mapper<Score> {
    Score findScoreByCondition(Integer subjectId, Integer userId);

    List<Score> findScoreBySubjectId(Integer subjectId);

    List<DistributionScore> findDistributionOfScore(Integer subjectId);
}