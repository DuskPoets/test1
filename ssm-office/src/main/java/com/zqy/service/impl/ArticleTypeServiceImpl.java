package com.zqy.service.impl;

import com.zqy.mapper.ArticleTypeMapper;
import com.zqy.pojo.Article;
import com.zqy.pojo.ArticleType;
import com.zqy.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;
    @Override
    public List<ArticleType> findAll() {
        return articleTypeMapper.selectAll();
    }
}
