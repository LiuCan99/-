package com.test;

import com.demo.es.ApplicationES;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationES.class)
public class TestConsumer {


    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    /**
     * 消费者
     * @param args
     */
    public static void main(String[] args) throws JMSException {


        //创建连接工程，使用默认路径
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        //获得连接
        Connection connection = connectionFactory.createConnection();
        //开始连接
        connection.start();


        //建立会话（自动确认，客户端发送和接收消息不需要做额外的工作）
        Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);

        //创建队列
        Queue queue =session.createQueue("HellowWorld");

        //消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);

        TextMessage message =(TextMessage) messageConsumer.receive(10000);

        if(message!=null){
            System.out.println(message.getText());
        }else {
            System.out.println("没有消息");
        }

        session.commit();
        session.close();
        connection.close();

    }


    @Test
    public  void  TestMQ() throws JMSException {
        MapMessage mapMessage =new ActiveMQMapMessage();
        mapMessage.setString("phone","123456");
        mapMessage.setString("code","9999");

        jmsMessagingTemplate.convertAndSend(queue,mapMessage);
    }


}
