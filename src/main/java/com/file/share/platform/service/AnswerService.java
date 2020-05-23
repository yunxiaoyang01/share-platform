package com.file.share.platform.service;
import com.file.share.platform.model.Answer;
import com.file.share.platform.core.Service;
import com.file.share.platform.model.User;
import com.file.share.platform.model.request.AnswerReq;


/**
 * Created by CodeGenerator on 2020/05/22.
 */
public interface AnswerService extends Service<Answer> {

    boolean submitAnswer(AnswerReq answerReq, User user);
}
