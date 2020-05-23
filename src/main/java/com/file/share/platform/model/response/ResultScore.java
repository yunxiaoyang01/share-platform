package com.file.share.platform.model.response;

import com.file.share.platform.model.Score;
import lombok.Data;

import java.util.List;

@Data
public class ResultScore {

	private List<ChoiceAnswer> choiceAnswers;
	private List<JudgeAnswer> judgeAnswers;
	private Score score;
}
