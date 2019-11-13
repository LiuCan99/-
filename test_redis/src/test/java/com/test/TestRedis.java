package com.test;


import com.demo.redis.ApplicationRedis;
import com.demo.redis.User;
import com.demo.redis.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationRedis.class)
public class TestRedis {

    @Resource
    private UserService userService;

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("name","1234");			//设置数据
        String pwd = jedis.get("password");		//获得数据
        System.out.println(pwd);
    }

    @Test
    public  void TestUser(){
        String save = userService.save("这是redis");
    }}
