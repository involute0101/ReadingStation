package com.dbtest.dao;

import com.dbtest.entity.Comment;

import java.util.List;

public interface CommentMappers {
    public List<Comment> selectComment(String bookName,int id);
}
