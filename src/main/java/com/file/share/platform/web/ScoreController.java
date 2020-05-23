package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.Score;
import com.file.share.platform.model.response.DistributionScore;
import com.file.share.platform.service.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/22.
*/
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    @PostMapping("/add")
    public Result add(Score score) {
        scoreService.save(score);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        scoreService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Score score) {
        scoreService.update(score);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Score score = scoreService.findById(id);
        return ResultGenerator.genSuccessResult(score);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Score> list = scoreService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/distributionOfScore")
    public Result distributionOfScore(@RequestParam(value = "subject_id")Integer subjectId, HttpServletRequest request){
        List<DistributionScore> distributionScoreList = scoreService.findDistributionOfScore(subjectId);
        return ResultGenerator.genSuccessResult(distributionScoreList);
    }
}
