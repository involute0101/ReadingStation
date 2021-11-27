package com.dbtest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BulletScreen {
    Account sender;
    String content;//Stringbuffer更好???
    //todo:弹幕信息，账号，弹幕时间
}