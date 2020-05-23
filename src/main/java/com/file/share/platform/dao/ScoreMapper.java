package com.file.share.platform.dao;

import com.file.share.platform.core.Mapper;
import com.file.share.platform.model.Score;

public interface ScoreMapper extends Mapper<Score> {
    Score findScoreByCondition(Integer subjectId, Integer userId);
}