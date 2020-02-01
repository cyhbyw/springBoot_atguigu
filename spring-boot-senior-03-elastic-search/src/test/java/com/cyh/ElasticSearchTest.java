package com.cyh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cyh.elastic.entity.Book;
import com.cyh.elastic.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testPut() {
        Book book = new Book(1, "红楼梦", "曹雪芹");
        Book index = bookRepository.index(book);
        System.out.println(index);
    }

    @Test
    public void testGet() {
        Book book = bookRepository.findOne(1);
        System.out.println(book);
    }

}
