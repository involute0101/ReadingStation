package com.dbtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
@Entity
@JsonIgnoreProperties(value = "handler")
public class Book {

    @Id
    private int id;

    private String bookName;

    private String uploaderAccount;

    /**
     * 书籍简介
     */
    private String description;

    private Date uploadTime;

    private Date changeTime;

    private String url = "/books/" + bookName + ".pdf";//暂不清楚初始化和@AllArgsConstructor是否有冲突

    private List<Comment> comments;
}
