package com.dbtest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    String name;
    String password;
    Integer lv;//可删
    Boolean vip;//可删
}
