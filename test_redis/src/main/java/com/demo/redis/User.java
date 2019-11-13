package com.demo.redis;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import javax.persistence.Table;
@Document(indexName = "user",type = "user")
@Table(name = "user")
public class User {

    @Id
    private  Integer id;

    private  String username;

    private String phone;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
    }

    public User(Integer id, String username, String phone, Integer age) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.age = age;
    }
}
