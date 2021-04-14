package com.zqy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zqy.mapper.ArticleMapper;
import com.zqy.pojo.Article;
import com.zqy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public PageInfo<Article> getPage(Integer pageSize, Integer pageNum, String articleName, Integer articleType) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleMapper.selectList(articleName,articleType);
        return new PageInfo<>(articles);
    }

    @Override
    public int addArticle(Article article) {
       return articleMapper.insertSelective(article);
    }

    @Override
    public int deleteArticleByIds(List ids) {
        Example example = new Example(Article.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("articleId",ids);
        return articleMapper.deleteByExample(example);
    }

    @Override
    public int updateArticle(Article article) {
      return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public Article getArticle(Integer articleId) {
         return articleMapper.selectByPrimaryKey(articleId);
    }
}
