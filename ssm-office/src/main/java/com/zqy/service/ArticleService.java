package com.zqy.service;

import com.github.pagehelper.PageInfo;
import com.zqy.pojo.Article;

import java.util.List;

public interface ArticleService {
    PageInfo<Article> getPage(Integer pageSize, Integer pageNum, String articleName, Integer articleType);

    int addArticle(Article article);

    int deleteArticleByIds(List ids);

    int updateArticle(Article article);

    Article getArticle(Integer articleId);
}
