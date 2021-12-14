package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;

@Data
@AllArgsConstructor
public class Comment {
    @Id
    private int id;

    private String bookName;

    private String  sender;

    private String content;
}