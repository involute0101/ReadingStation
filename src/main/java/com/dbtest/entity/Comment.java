package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;

@Data
@AllArgsConstructor
public class Comment {
    @Id
    int id;
    String bookName;
    int isDescription;//true表示对书的描述,上传者和管理员使用
    String  sender;
    String content;//Stringbuffer更好???
}