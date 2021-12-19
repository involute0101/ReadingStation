package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String account;//为主键

    private String name;

    private String password;

    private String email;

    private Integer lv;

    private Integer vip;

    public Account(String account){
        this.account=account;
    }
}
