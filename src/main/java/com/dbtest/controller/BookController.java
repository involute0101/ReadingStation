package com.dbtest.controller;

import com.dbtest.entity.Book;
import com.dbtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/Book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/getByName")
    @ResponseBody
    public Book getBookByName(@RequestBody String bookName) {
        System.out.println(bookService.getBook(bookName));
        return bookService.getBook(bookName);
    }
    @PostMapping("/uploadBooks")
    @ResponseBody
    public String addBook(@RequestBody MultipartFile file) throws IOException {
        Properties props = new Properties();
        props.load(this.getClass().getResourceAsStream("/download.properties"));//todo:部署到服务器上记得改配置文件中的位置
        String filepath=props.getProperty("bookpath");
        String bookName=file.getOriginalFilename();
        File book = new File(filepath,bookName);
        if (!book.getParentFile().exists()) {
            book.getParentFile().mkdirs();}
        file.transferTo(new File(filepath + File.separator + bookName));
        return "Success";
    }

    @GetMapping(value = "/all")
    public List<Book> getAllBook() {
        return bookService.getAllBooks();
    }

}
