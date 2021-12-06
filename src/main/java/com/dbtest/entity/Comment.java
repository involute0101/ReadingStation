package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    String bookName;
    Integer isDescription;//true表示对书的描述,上传者和管理员使用
    String  sender;
    String content;//Stringbuffer更好???
    //todo:弹幕信息，账号，弹幕时间
}