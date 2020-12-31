package com.loveraising.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: LoveRaising
 * @description: 文件上传
 * @created: 2020/12/24 17:31
 */
@RequestMapping("/file")
@RestController
public class UploadController {
    /**
     * 文件上传功能
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/upload.do",method= RequestMethod.POST)
    public R upload(MultipartFile[] file, HttpServletRequest request)  {
        String path = request.getSession().getServletContext().getRealPath("upload");
        List<String> newFileNames = new ArrayList<>();
        for (MultipartFile multipartFile : file) {
            String fileName = multipartFile.getOriginalFilename();
            String newFileName = UUID.randomUUID().toString()+fileName;
            File dir = new File(path,newFileName);
            if(!dir.exists()){
                dir.mkdirs();
            }
            //MultipartFile自带的解析方法
            try {
                multipartFile.transferTo(dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
            newFileNames.add("upload/"+newFileName);
        }
        return R.ok(newFileNames);
    }

    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/download.do")
    public void down(HttpServletRequest request, HttpServletResponse response){
        //模拟文件，myfile.txt为需要下载的文件
        String fileName = request.getSession().getServletContext().getRealPath("upload/")+request.getParameter("fileName");
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        //获取输入流
        InputStream bis = null;
        BufferedOutputStream out =null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
            //假如以中文名下载的话
            String filename = UUID.randomUUID().toString()+fileType;
            //转码，免得文件名中文乱码
            filename = URLEncoder.encode(filename,"UTF-8");
            //设置文件下载头
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while((len = bis.read()) != -1){
                out.write(len);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
