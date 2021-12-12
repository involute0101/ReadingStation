package com.dbtest.dao;

import com.dbtest.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMappers {
    public List<Comment> selectComment(String bookName);
    public void insertComment(String content,String account,String bookName,int isDescription)throws Exception;
}
