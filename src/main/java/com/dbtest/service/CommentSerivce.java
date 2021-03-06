package com.dbtest.service;

import com.dbtest.dao.CommentMappers;
import com.dbtest.entity.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
@Service
public class CommentSerivce {
    @Autowired
    private SqlSessionFactory mybatisSqlSessionFactory;

    public List<Comment> getComment(String bookName) {
        try (SqlSession sqlSession = mybatisSqlSessionFactory.openSession()) {
            CommentMappers commentMapper = sqlSession.getMapper(CommentMappers.class);
            return commentMapper.getCommentByBookName(bookName);
        }
    }

    public boolean insertComment(Comment comment) {
        try (SqlSession sqlSession = mybatisSqlSessionFactory.openSession()) {
            CommentMappers commentMapper = sqlSession.getMapper(CommentMappers.class);
            commentMapper.insertComment(comment);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
