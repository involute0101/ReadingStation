package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    int id;
    String bookName;
    int isDescription;//true表示对书的描述,上传者和管理员使用
    Account  sender;
    String content;//Stringbuffer更好???
}