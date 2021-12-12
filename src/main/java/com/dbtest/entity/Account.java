package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    String account;//为主键
    String name;
    String password;
    Integer lv;//可删
    Integer vip;//可删
    public Account(String account){
        this.account=account;
    }
}
