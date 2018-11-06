package com.atguigu;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atguigu.bean.Book;

/**
 * @author: CYH
 * @date: 2018/11/6 0006 8:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqpApplicationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private AmqpAdmin admin;


    @Test
    public void testConvertAndSend() {
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        map.put("msg", "这是第一个消息");
        map.put("name", "CYH");
        map.put("date", "20181106");
        map.put("data", Arrays.asList(34, "Hello", 78.99));
        rabbitTemplate.convertAndSend("directTest", "atguigu.news", map);
    }

    @Test
    public void testConvertAndSend2() {
        Book book = new Book("西游记", "吴承恩");
        rabbitTemplate.convertAndSend("directTest", "atguigu.news", book);
    }

    @Test
    public void testReceiveAndConvert() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.err.println(o.getClass());
        System.err.println(o);
    }

    @Test
    public void testFanout() {
        Book book = new Book("三国演义", "罗贯中");
        rabbitTemplate.convertAndSend("fanoutTest", "", book);
    }

    @Test
    public void createExchange() {
        admin.declareExchange(new DirectExchange("admin.exchange"));
    }

    @Test
    public void createQueue() {
        admin.declareQueue(new Queue("admin.queue", true));
    }

    @Test
    public void binding() {
        admin.declareBinding(
                new Binding("admin.queue", Binding.DestinationType.QUEUE, "admin.exchange", "amqp.haha", null));
    }

}
