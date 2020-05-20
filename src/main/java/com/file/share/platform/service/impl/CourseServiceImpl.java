package com.file.share.platform.service.impl;

import com.file.share.platform.dao.CourseMapper;
import com.file.share.platform.model.Course;
import com.file.share.platform.service.CourseService;
import com.file.share.platform.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
@Service
@Transactional
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {
    @Resource
    private CourseMapper courseMapper;

}
