package com.test;

import com.demo.es.ApplicationES;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationES.class)
public class TestProducer {

    /**
     * 生产者
     * @param args
     * @throws JMSException
     */
    public static void main(String[] args) throws JMSException {

        //创建连接工程 使用默认路径（tcp://localhost:61616）
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory();

        //获得连接
        Connection connection = connectionFactory.createConnection();

        //开始连接
        connection.start();

        //建立会话（自动确认，客户端发送和接收消息不需要做额外的工作）
        Session session =connection.createSession(true,Session.AUTO_ACKNOWLEDGE);

        //创建队列
        Queue queue = session.createQueue("HelloWorld!");

        //生产者发送消息
        MessageProducer producer=session.createProducer(queue);
        TextMessage textMessage = session.createTextMessage("我是生产者：消息1");
        producer.send(textMessage);

        session.commit();
        session.close();
        connection.close();
    }
}
