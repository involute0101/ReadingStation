package com.dbtest.controller;

import com.dbtest.entity.Book;
import com.dbtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BookService bookService;

    @PostMapping("/upload")
    @ResponseBody
    public void upload(@RequestPart MultipartFile file, @RequestPart String description, @RequestPart String userAccount
            , HttpServletResponse response) throws IOException {
        Book book = new Book();
        book.setDescription(description);
        book.setUploaderAccount(userAccount);
        String fileName = file.getOriginalFilename();
        book.setBookName(fileName.substring(0,fileName.indexOf(".pdf")));
        File dest = new File(uploadFilePath+fileName);
        Files.copy(file.getInputStream(), dest.toPath());
        //return "Upload file success : " + dest.getAbsolutePath();
        bookService.insertBook(book);
        response.sendRedirect("/student/index");
    }

}
