package com.loveraising.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @program: LoveRaising
 * @description: 文件上传
 * @created: 2020/12/24 17:31
 */
@RequestMapping("/file")
@Controller
public class UploadController {

    @GetMapping("/toupload.do")
    public String toUpload(){
        return "index";
    }



    /**
     * 文件上传功能
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/upload.do",method= RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request)  {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString()+fileName;
        File dir = new File(path,newFileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        try {
            file.transferTo(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok!";
    }

    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/down.do")
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
