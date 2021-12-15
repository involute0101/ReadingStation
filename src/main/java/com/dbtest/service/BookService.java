package com.dbtest.service;

import com.dbtest.dao.BookMappers;
import com.dbtest.dao.CommentMappers;
import com.dbtest.entity.Book;
import com.dbtest.entity.Comment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Service
public class BookService {

    @Autowired
    private SqlSessionFactory mybatisSqlSessionFactory;

    public List<Book> getBook(String bookName){
        try(SqlSession sqlSession=mybatisSqlSessionFactory.openSession()) {
            BookMappers mapper = sqlSession.getMapper(BookMappers.class);
            return mapper.selectBookByName(bookName);

        }
    }

    public Book getOneBook(String bookName){
        try(SqlSession sqlSession = mybatisSqlSessionFactory.openSession()){
            BookMappers mappers = sqlSession.getMapper(BookMappers.class);
            return mappers.selectOneBookByName(bookName);
        }
    }

    public List<Book> getAllBooks(){
        try(SqlSession sqlSession = mybatisSqlSessionFactory.openSession()){
            BookMappers mappers = sqlSession.getMapper(BookMappers.class);
            return mappers.selectAllBook();
        }
    }

    public List<Book> getBooksByAccount(String account){
        try(SqlSession sqlSession = mybatisSqlSessionFactory.openSession()){
            BookMappers mappers = sqlSession.getMapper(BookMappers.class);
            return mappers.getBooksByAccount(account);
        }
    }

    public void insertBook(Book book){
        book.setUploadTime(new Date());
        book.setChangeTime(book.getUploadTime());
        try(SqlSession sqlSession = mybatisSqlSessionFactory.openSession()){
            BookMappers mappers = sqlSession.getMapper(BookMappers.class);
            mappers.insertBook(book);
            sqlSession.commit();
        }
    }
}
