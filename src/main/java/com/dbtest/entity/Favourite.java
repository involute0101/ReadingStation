package com.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favourite {

    @Id
    private Integer id;

    private String account;

    private Integer bookId;

    private String bookName;

}
