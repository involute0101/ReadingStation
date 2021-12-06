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
    public List<Comment> getCommentRandomly(String bookName,int nums){
        try(SqlSession sqlSession=mybatisSqlSessionFactory.openSession()) {
            CommentMappers commentMapper=sqlSession.getMapper(CommentMappers.class);
            List<Comment> comments =new ArrayList<>();
            Random random=new Random();
            int id=0;
            while(comments.size()<=nums){
                id=random.nextInt(100)+1;
                comments.add(commentMapper.selectComment(bookName,id).get(id));
                //此处可优化，建议优化
            }
            return comments;
        }
    }
}
