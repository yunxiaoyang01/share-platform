package com.file.share.platform.model.response;

import com.file.share.platform.model.Answer;
import com.file.share.platform.model.Judge;

public class JudgeAnswer {

	private Answer answer;
	private Judge judge;
	/**
	 * @return the answer
	 */
	public Answer getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	/**
	 * @return the judge
	 */
	public Judge getJudge() {
		return judge;
	}
	/**
	 * @param judge the judge to set
	 */
	public void setJudge(Judge judge) {
		this.judge = judge;
	}
	
	
}
