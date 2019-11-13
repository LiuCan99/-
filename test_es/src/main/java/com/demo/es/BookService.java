package com.demo.es;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
@CacheConfig(cacheNames="BookService")// cacheName 是一定要指定的属性，可以通过 @CacheConfig 声明该类的通用配置
public class BookService {

    @Resource
    private  BookMapper bookMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Cacheable(value = "allBook")
    public Page<Book> findAllBook(Pageable pageable){

        Page<Book> all = bookMapper.findAll(pageable);
        return  all;
    }

    public Book saveBook(Book book){
        Book save = bookMapper.save(book);
        return save;
    }

    public void testRedis(String str){
        //向redis中存储值（key，value）
        stringRedisTemplate.opsForValue().set("test",str);
        //向redis中  key=“test” 的 value追加“666”
        stringRedisTemplate.opsForValue().append("test","666");
        //获得key=“test”的value值
        String test = stringRedisTemplate.opsForValue().get("test");


        System.out.println(test);
    }

}
