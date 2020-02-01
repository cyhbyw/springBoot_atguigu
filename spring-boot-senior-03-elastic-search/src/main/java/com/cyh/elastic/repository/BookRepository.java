package com.cyh.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.cyh.elastic.entity.Book;

@Component
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
}
