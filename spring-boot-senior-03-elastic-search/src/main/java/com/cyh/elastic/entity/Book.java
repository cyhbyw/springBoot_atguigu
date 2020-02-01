package com.cyh.elastic.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "cyh_test")
public class Book {

    private Integer id;
    private String bookName;
    private String author;


}
