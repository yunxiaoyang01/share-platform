package com.file.share.platform.service.impl;

import com.file.share.platform.dao.FileMapper;
import com.file.share.platform.model.File;
import com.file.share.platform.service.FileService;
import com.file.share.platform.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
@Service
@Transactional
public class FileServiceImpl extends AbstractService<File> implements FileService {
    @Resource
    private FileMapper fileMapper;

    @Override
    public List<File> findFileByCourseId(Integer courseId) {
        return fileMapper.findFileByCourseId(courseId);
    }
}
