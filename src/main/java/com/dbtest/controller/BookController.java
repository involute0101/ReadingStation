package com.dbtest.controller;

import com.dbtest.entity.Book;
import com.dbtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;


@RestController
@RequestMapping("/Book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/getByName")
    public List<Book> getBookByName(@RequestParam String bookName) {
        return bookService.getBook(bookName);
    }

    @GetMapping(value = "/oneBook")
    public Book getOneBookByName(@RequestParam String bookName){
        return bookService.getOneBook(bookName);
    }

    @PostMapping("/uploadBooks")
    @ResponseBody
    public String addBook(@RequestBody MultipartFile file) throws IOException {//todo:稍后再说
        return "success";
    }

    @GetMapping(value = "/all")
    public List<Book> getAllBook() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/byAccount")
    public List<Book> getBooksByAccount(@RequestParam String account){
        return bookService.getBooksByAccount(account);
    }

}
