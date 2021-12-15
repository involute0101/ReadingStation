package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    private int id;

    private String bookName;

    private String  sender;

    private String content;

    private Date sendTime;
}