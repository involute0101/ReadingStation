package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    int id;

    String bookName;

    String  senderAccount;

    String content;
}