package com.dbtest.dao;

import com.dbtest.entity.Comment;

import java.util.List;

public interface CommentMappers {
    public List<Comment> selectComment(String bookName,int id);
    public void insertComment(String content,String account,String bookName,int isDescription)throws Exception;
}
