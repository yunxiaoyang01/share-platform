package com.file.share.platform.service.impl;

import com.file.share.platform.dao.ScoreMapper;
import com.file.share.platform.model.Score;
import com.file.share.platform.model.response.DistributionScore;
import com.file.share.platform.service.ScoreService;
import com.file.share.platform.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/22.
 */
@Service
@Transactional
public class ScoreServiceImpl extends AbstractService<Score> implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public Score findScoreByCondition(Integer subjectId, Integer userId) {
        return scoreMapper.findScoreByCondition(subjectId,userId);
    }

    @Override
    public List<Score> findScoreBySubjectId(Integer subjectId) {
        return scoreMapper.findScoreBySubjectId(subjectId);
    }

    @Override
    public List<DistributionScore> findDistributionOfScore(Integer subjectId) {
        return scoreMapper.findDistributionOfScore(subjectId);
    }
}
