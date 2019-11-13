package com.czxy.springTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        //使用配置文件来启动一个ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

        System.out.println("启动成功");

        //从context中取出我们的bean，而不是用new MessageServiceImpl()这种方式
        MessageService messageService = context.getBean(MessageService.class);

        //输出
        System.out.println(messageService.getMessage());


    }
}
