package com.dbtest.controller;

import com.dbtest.entity.Comment;
import com.dbtest.service.CommentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/Comment")
public class CommentController {
    @Autowired
    CommentSerivce commentSerivce;
    @PostMapping("/getcomment")
    public List<Comment> getCommentRandomly(String bookName,int num){
        return commentSerivce.getCommentRandomly(bookName,num);
    }

}
