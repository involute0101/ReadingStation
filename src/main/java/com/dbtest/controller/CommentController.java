package com.dbtest.controller;

import com.dbtest.entity.Comment;
import com.dbtest.service.CommentSerivce;
import com.dbtest.vo.GetComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Comment")
public class CommentController {

    @Autowired
    CommentSerivce commentSerivce;

    @PostMapping("/getComment")
    @ResponseBody
    public List<Comment> getComment(@RequestBody GetComment getComment) {
        return commentSerivce.getComment(getComment.getBookName());
    }

    @PostMapping("/insertComment")
    @ResponseBody
    public void insertComment(@RequestPart String userAccount, @RequestPart String content,
                                 @RequestPart String commentBookName, HttpServletResponse response) throws IOException {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setSender(userAccount);
        commentBookName = commentBookName.replaceAll("%20"," ");
        comment.setBookName(commentBookName);
        comment.setSendTime(new Date());
        commentSerivce.insertComment(comment);
        response.sendRedirect("/student/book?bookName="+commentBookName);
    }
}
