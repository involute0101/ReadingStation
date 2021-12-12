package com.dbtest.controller;

import com.dbtest.vo.GetComment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Properties;

@Controller
@RequestMapping("/downloads")
public class DownloadController {//测试通过
    @GetMapping("/{bookName}")
    public String downloadBooks(HttpServletResponse response, @PathVariable("bookName")String bookName) throws IOException {
        Properties props = new Properties();
        props.load(this.getClass().getResourceAsStream("/download.properties"));//todo:部署到服务器上记得改配置文件中的位置
        String filepath=props.getProperty("bookpath");
        bookName=bookName;//后缀
//        String filepath="D:/books/";//文件位置
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(bookName, "UTF-8"));
        File file = new File(filepath,bookName);
        InputStream input=new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        byte[] buff =new byte[1024];//缓存优化
        int index=0;
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return null;
    }
}
