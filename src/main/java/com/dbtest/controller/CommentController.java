package com.dbtest.controller;

import com.dbtest.entity.Comment;
import com.dbtest.service.CommentSerivce;
import com.dbtest.vo.GetComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Comment")
public class CommentController {
    @Autowired
    CommentSerivce commentSerivce;
    @PostMapping("/getComment")
    @ResponseBody
    public ArrayList<Comment> getCommentRandomly(@RequestBody GetComment getComment){
        return (ArrayList<Comment>) commentSerivce.getComment(getComment.getBookName());
    }
    @PostMapping("/insertComment")
    @ResponseBody
    public boolean insertComment(@RequestBody Comment comment){//测试通过
        return commentSerivce.insertComment(comment);
    }
}
