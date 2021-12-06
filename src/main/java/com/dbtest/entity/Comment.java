package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    int id;//id为主键
    String bookName;
    boolean isDescription=false;//true表示对书的描述,上传者和管理员使用
    Account sender;
    String content;//Stringbuffer更好???
    //todo:弹幕信息，账号，弹幕时间
}