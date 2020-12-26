package com.loveraising.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName UploadController
 * @Description //TODO
 * @Author GuXinYu
 * @Date 2020/12/27 0:20
 * @Version 1.0
 **/
@RestController
public class UploadController {
    /**
     * 文件上传
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/do_upload.do",method = RequestMethod.POST)
    public R doUpload(@RequestParam("pic") MultipartFile[] file, HttpServletRequest request){
        //生成图片上传路径
        String servletContext = request.getSession().getServletContext().getRealPath("/image/");
        List<String> fileNames = new ArrayList<>();
        for (MultipartFile multipartFile : file) {
            //step1:获取文件的名称
            String filename = multipartFile.getOriginalFilename();
            if (StringUtils.isEmpty(filename)){
                return R.failed("上传文件名不能为空");
            }
            //step2:获取原文件的扩展名
            String ext = filename.substring(filename.lastIndexOf("."));
            //step3:定义新的文件名,为文件生产一个唯一名称
            String newName = UUID.randomUUID().toString();
            String newFilename = newName+ext;
            try {
                //step5:创建文件
                File newFile = new File(servletContext+newFilename);
                newFile.mkdirs();
                multipartFile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileNames.add(newFilename);
        }
        return R.ok(fileNames);
    }
}
