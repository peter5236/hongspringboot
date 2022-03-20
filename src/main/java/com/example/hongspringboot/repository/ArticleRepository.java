package com.example.hongspringboot.repository;

import com.example.hongspringboot.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
