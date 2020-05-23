package com.file.share.platform.service;
import com.file.share.platform.model.Score;
import com.file.share.platform.core.Service;
import com.file.share.platform.model.response.DistributionScore;

import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/22.
 */
public interface ScoreService extends Service<Score> {

    Score findScoreByCondition(Integer id, Integer id1);

    List<Score> findScoreBySubjectId(Integer id);

    List<DistributionScore> findDistributionOfScore(Integer subjectId);
}
