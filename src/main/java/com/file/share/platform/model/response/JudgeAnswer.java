package com.file.share.platform.model.response;

import com.file.share.platform.model.Answer;
import com.file.share.platform.model.Judge;
import lombok.Data;

@Data
public class JudgeAnswer extends Judge{

	private String answer;

	private String goodAnswer;

	private boolean isTrue;

	private Integer questionType;
}
