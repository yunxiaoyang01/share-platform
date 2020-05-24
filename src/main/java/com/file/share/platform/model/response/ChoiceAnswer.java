package com.file.share.platform.model.response;

import com.file.share.platform.model.Answer;
import com.file.share.platform.model.Choice;
import lombok.Data;

@Data
public class ChoiceAnswer extends Choice{
	private String answer;

	private String goodAnswer;

	private boolean isTrue;

	private Integer questionType;
}
