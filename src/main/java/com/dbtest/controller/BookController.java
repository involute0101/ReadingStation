package com.dbtest.controller;

import com.dbtest.entity.Book;
import com.dbtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/getByName")
    @ResponseBody
    public Book getBookByName(@RequestBody String bookName){
        System.out.println(bookService.getBook(bookName));
        return bookService.getBook(bookName);
    }

}
