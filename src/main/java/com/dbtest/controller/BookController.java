package com.dbtest.controller;

import com.dbtest.entity.Book;
import com.dbtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/Book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/getByName")
    public Book getBookByName(String bookName){
        return bookService.getBook(bookName);
    }

}
