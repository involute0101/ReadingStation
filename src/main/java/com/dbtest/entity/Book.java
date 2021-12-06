package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Book {
    String bookName;
    int id;
    Account uploader;
    Data uploadTime;
    Data changeTime;
    String url="/books/"+bookName+".pdf";//暂不清楚初始化和@AllArgsConstructor是否有冲突
    List<Comment>comments;
}
