package com.dbtest.controller;

import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

@Controller
public class UploadController {


    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestPart MultipartFile file) throws IOException {//测试通过
        String fileName = file.getOriginalFilename();
        Properties props = new Properties();
        props.load(this.getClass().getResourceAsStream("/download.properties"));//todo:部署到服务器上记得改配置文件中的位置
        String filepath=props.getProperty("bookpath");
        File dest = new File(filepath+"/"+fileName);
        Files.copy(file.getInputStream(), dest.toPath());
        return "Upload file success : " + dest.getAbsolutePath();
    }

}
