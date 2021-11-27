package com.dbtest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BulletScreen {
    Account sender;
    String content;//Stringbuffer更好???
}