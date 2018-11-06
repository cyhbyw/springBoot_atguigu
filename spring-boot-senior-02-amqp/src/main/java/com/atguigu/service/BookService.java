package com.atguigu.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Book;

/**
 * @author: CYH
 * @date: 2018/11/6 0006 8:31
 */
@Service
public class BookService {

    @RabbitListener(queues = {"atguigu.news"})
    public void receive(Book book) {
        System.err.println("RabbitListener received message: " + book);
    }

    @RabbitListener(queues = {"atguigu"})
    public void receive02(Message message) {
        System.err.println("message.getBody(): " + message.getBody() + ", message.getMessageProperties(): "
                + message.getMessageProperties());
    }


}
