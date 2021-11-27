package com.dbtest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    String account;//为主键
    String name;
    String password;
    Integer lv;//可删
    Boolean vip;//可删
    public boolean isPass(String password){
        return this.password.equals(password);
    }
}
