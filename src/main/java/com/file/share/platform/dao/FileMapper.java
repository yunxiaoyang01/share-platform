package com.file.share.platform.dao;

import com.file.share.platform.core.Mapper;
import com.file.share.platform.model.File;

import java.util.List;

public interface FileMapper extends Mapper<File> {
    List<File> findFileByCourseId(Integer courseId);
}