package com.file.share.platform.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TestAspect {

    Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Pointcut("execution(public * com.file.share.platform.web.JudgeController.*(..)))")
    public void TestAspect(){

    }

    @Pointcut("execution(public * com.file.share.platform.web..detail(..)))")
    public void A(){

    }

    @Before("TestAspect()")
    public void doBefore(){
        logger.info("开始查询单选题");
    }

    @Before("A()")
    public void doABefore(){
        logger.info("开始选择题");
    }


    @After("TestAspect()")
    public void doAfter(){
        logger.info("单选题查询结束");
    }

    @AfterReturning("TestAspect()")
    public void doAfterReturn(){
        logger.info("单选题查询返回");
    }
}
