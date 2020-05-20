package com.file.share.platform.web;
import com.alibaba.fastjson.JSONObject;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.File;
import com.file.share.platform.service.FileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import static com.file.share.platform.core.ProjectConstant.*;
/**
* Created by CodeGenerator on 2020/05/20.
*/
@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    private FileService fileService;

    @PostMapping("/add")
    public Result add(@RequestBody File file) {
        fileService.save(file);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        fileService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(File file) {
        fileService.update(file);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        File file = fileService.findById(id);
        return ResultGenerator.genSuccessResult(file);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<File> list = fileService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping(value = "/upload")
    public Result fileUpload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = PROJECT_PATH+STATIC_PATH; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        java.io.File dest = new java.io.File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/file/" + fileName;
        return ResultGenerator.genSuccessResult(filename);
    }
    @PostMapping(value = "/download")
    public Result fileDownLoad(@RequestBody JSONObject jsonObject , HttpServletResponse response){
        String fileUrl = jsonObject.getString("file_url");
        String[] fileArray = fileUrl.split("/");
        String pathName = PROJECT_PATH+STATIC_PATH+fileArray[fileArray.length-1];
        java.io.File file = new java.io.File(pathName);
        if (!file.exists()){
            return ResultGenerator.genFailResult("文件不存在");
        }
        try {
            //设置响应头，控制浏览器下载该文件
            response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileArray[fileArray.length-1], "UTF-8"));
            response.setHeader("content-transfer-encoding","binary");
            //读取要下载的文件，保存到文件输入流
            FileInputStream in = null;

            in = new FileInputStream(pathName);
            //创建输出流
            OutputStream out = response.getOutputStream();
            //创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            //循环将输入流中的内容读取到缓冲区当中
            while ((len = in.read(buffer)) > 0) {
                //输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultGenerator.genSuccessResult();
    }
}
