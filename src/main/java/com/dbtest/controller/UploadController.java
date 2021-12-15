package com.dbtest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

@Controller
public class UploadController {

    @Value("${PDF.filePath}")
    private String uploadFilePath;

    @PostMapping("/upload")
    @ResponseBody
    public void upload(@RequestPart MultipartFile file, HttpServletResponse response) throws IOException {//测试通过
        System.out.println("上传路径："+uploadFilePath);
        String fileName = file.getOriginalFilename();
        File dest = new File(uploadFilePath+fileName);
        Files.copy(file.getInputStream(), dest.toPath());
        //return "Upload file success : " + dest.getAbsolutePath();
        response.sendRedirect("/student/index");
    }

}
