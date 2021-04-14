package com.zqy.mapper;

import com.zqy.pojo.Article;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleMapper extends Mapper<Article> {

    List<Article> selectList(@Param("articleName") String articleName,
                             @Param("articleType") Integer articleType);

}
