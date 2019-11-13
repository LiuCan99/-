package com.demo.es;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import javax.persistence.Table;

@Document(indexName = "book",type = "book")
@Table(name = "book")
public class Book {

    @Id
    private Integer id;
    private String bname;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
