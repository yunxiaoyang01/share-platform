package com.file.share.platform.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.file.share.platform.model.Score;
import com.file.share.platform.model.Subject;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class ResultScore extends Subject{

	@JsonProperty("choices")
	private List<ChoiceAnswer> choiceAnswers;

	@JsonProperty("judges")
	private List<JudgeAnswer> judgeAnswers;
	private Score score;
}
