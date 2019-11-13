package com.test;

import com.demo.es.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationES.class)
public class TestES {

    @Resource
    private BookService bookService;

    @Test
    public  void  es(){
        Pageable pageable= PageRequest.of(0,2);
        Page<Book> allBook = bookService.findAllBook(pageable);
        System.out.println(allBook.getTotalPages());
    }


    @Test
    public  void  save(){
        Book book=new Book();
        book.setBname("语文");
        book.setPrice(20.00);
        Book book1 = bookService.saveBook(book);
    }

    @Test
    public void testRedis(){
        String str ="demo01";
        bookService.testRedis(str);
    }
}
