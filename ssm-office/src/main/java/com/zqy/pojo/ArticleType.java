package com.zqy.pojo;

import javax.persistence.*;

@Table(name = "article_type")
public class ArticleType {
    @Id
    @Column(name = "article_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleTypeId;

    private String name;

    /**
     * @return article_type_id
     */
    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    /**
     * @param articleTypeId
     */
    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
