package com.dbtest.dao;

import com.dbtest.entity.Book;

import java.util.List;

public interface BookMappers {
    public List<Book> selectBookByName(String bookName);

    public List<Book> selectAllBook();

    //public void insertBook();//todo:稍后再说
}
