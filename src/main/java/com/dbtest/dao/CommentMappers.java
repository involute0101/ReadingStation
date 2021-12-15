package com.dbtest.dao;

import com.dbtest.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMappers {

    public List<Comment> getCommentByBookName(String bookName);

    public void insertComment(Comment comment)throws Exception;
}
