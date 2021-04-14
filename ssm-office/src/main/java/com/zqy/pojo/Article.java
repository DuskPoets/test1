package com.zqy.pojo;

import javax.persistence.*;

@Table(name = "article")
public class Article {
    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;

    @Column(name = "article_name")
    private String articleName;

    @Column(name = "stock_num")
    private Integer stockNum;

    @Column(name = "stock_unit")
    private String stockUnit;

    @Column(name = "article_type")
    private Integer articleType;

    @Column(name = "article_describe")
    private String articleDescribe;


    private ArticleType type;

    public Article() {
    }

    public Article(Integer articleId, String articleName, Integer stockNum, String stockUnit, Integer articleType, String articleDescribe, ArticleType type) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.stockNum = stockNum;
        this.stockUnit = stockUnit;
        this.articleType = articleType;
        this.articleDescribe = articleDescribe;
        this.type = type;
    }

    public ArticleType getType() {
        return type;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    /**
     * @return article_id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * @return article_name
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * @param articleName
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    /**
     * @return stock_num
     */
    public Integer getStockNum() {
        return stockNum;
    }

    /**
     * @param stockNum
     */
    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    /**
     * @return stock_unit
     */
    public String getStockUnit() {
        return stockUnit;
    }

    /**
     * @param stockUnit
     */
    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit == null ? null : stockUnit.trim();
    }

    /**
     * @return article_type
     */
    public Integer getArticleType() {
        return articleType;
    }

    /**
     * @param articleType
     */
    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    /**
     * @return article_describe
     */
    public String getArticleDescribe() {
        return articleDescribe;
    }

    /**
     * @param articleDescribe
     */
    public void setArticleDescribe(String articleDescribe) {
        this.articleDescribe = articleDescribe == null ? null : articleDescribe.trim();
    }
}
