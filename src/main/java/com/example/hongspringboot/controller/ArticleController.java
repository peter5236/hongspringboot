package com.example.hongspringboot.controller;

import com.example.hongspringboot.dto.ArticleForm;
import com.example.hongspringboot.entity.Article;
import com.example.hongspringboot.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해 놓은 객체를 가져다가 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());
        // 1. dto -> entity 변환
        Article article = form.toEntity();
        System.out.println(article.toString());

        // 2. repository에게 entity를 db에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
