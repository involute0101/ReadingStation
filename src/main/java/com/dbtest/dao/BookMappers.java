package com.dbtest.dao;

import com.dbtest.entity.Book;

import java.util.List;

public interface BookMappers {

    /**
     * 根据书名关键字，进行模糊查询
     * @param bookName  书名
     * @return
     */
    public List<Book> selectBookByName(String bookName);

    public Book selectOneBookByName(String bookName);

    public List<Book> selectAllBook();

    //public void insertBook();//todo:稍后再说
}
