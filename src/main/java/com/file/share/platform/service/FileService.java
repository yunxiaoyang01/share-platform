package com.file.share.platform.service;
import com.file.share.platform.model.File;
import com.file.share.platform.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2020/05/20.
 */
public interface FileService extends Service<File> {

    List<File> findFileByCourseId(Integer id);
}
