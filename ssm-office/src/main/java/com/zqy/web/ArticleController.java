package com.zqy.web;

import com.github.pagehelper.PageInfo;
import com.zqy.pojo.Article;
import com.zqy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("article")
@CrossOrigin
public class ArticleController  {
    @Autowired
    private ArticleService articleService;

    @GetMapping(value = {"/page/{pageSize}/{pageNum}",
                        "/page/name/{pageSize}/{pageNum}/{articleName}",
                        "/page/type/{pageSize}/{pageNum}/{articleType}",
                        "/page/{pageSize}/{pageNum}/{articleName}/{articleType}"
    })
    public ResponseEntity getPage(@PathVariable Integer pageSize,
                                  @PathVariable Integer pageNum,
                                  @PathVariable(value = "articleName",required = false) String articleName,
                                  @PathVariable(value = "articleType",required = false) Integer articleType){
        PageInfo<Article> page = articleService.getPage(pageSize,pageNum,articleName,articleType);
        if (page!=null){
            return ResponseEntity.ok(page);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    public ResponseEntity addArticle(@RequestBody Article article){
        int a = articleService.addArticle(article);
        if (a>0) {
            return ResponseEntity.ok(a);
    }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping
    public ResponseEntity deleteArticle(@RequestBody List<Integer> deleteIds){
        System.out.println(deleteIds);
        int a = articleService.deleteArticleByIds(deleteIds);
        if (a>0) {
            return ResponseEntity.ok(a);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PutMapping
    public ResponseEntity updateArticle(@RequestBody Article article){
        int a = articleService.updateArticle(article);
        if (a>0) {
            return ResponseEntity.ok(a);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/one/{articleId}")
    public ResponseEntity getArticle(@PathVariable Integer articleId){
        Article article = articleService.getArticle(articleId);
        if (article!=null){
            return ResponseEntity.ok(article);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
