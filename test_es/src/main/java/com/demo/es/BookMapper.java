package com.demo.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookMapper extends ElasticsearchRepository<Book,Integer> {

}
