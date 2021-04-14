package com.zqy.pojo;

import javax.persistence.*;

@Table(name = "apply")
public class Apply {
    @Id
    @Column(name = "apply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applyId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "apply_num")
    private Integer applyNum;

    @Column(name = "apply_unit")
    private String applyUnit;

    @Column(name = "apply_date")
    private String applyDate;

    @Column(name = "apply_state")
    private Integer applyState;

    @Column(name = "apply_reason")
    private String applyReason;


    private Article article;

    private ApplyState state;

    private User user;

    public Apply() {
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public ApplyState getState() {
        return state;
    }

    public void setState(ApplyState state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Apply(Integer applyId, Integer userId, Integer articleId, Integer applyNum, String applyUnit, String applyDate, Integer applyState, String applyReason, Article article, ApplyState state, User user) {
        this.applyId = applyId;
        this.userId = userId;
        this.articleId = articleId;
        this.applyNum = applyNum;
        this.applyUnit = applyUnit;
        this.applyDate = applyDate;
        this.applyState = applyState;
        this.applyReason = applyReason;
        this.article = article;
        this.state = state;
        this.user = user;
    }

    /**
     * @return apply_id
     */
    public Integer getApplyId() {
        return applyId;
    }

    /**
     * @param applyId
     */
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * @return apply_num
     */
    public Integer getApplyNum() {
        return applyNum;
    }

    /**
     * @param applyNum
     */
    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    /**
     * @return apply_unit
     */
    public String getApplyUnit() {
        return applyUnit;
    }

    /**
     * @param applyUnit
     */
    public void setApplyUnit(String applyUnit) {
        this.applyUnit = applyUnit == null ? null : applyUnit.trim();
    }

    /**
     * @return apply_date
     */
    public String getApplyDate() {
        return applyDate;
    }

    /**
     * @param applyDate
     */
    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate == null ? null : applyDate.trim();
    }

    /**
     * @return apply_state
     */
    public Integer getApplyState() {
        return applyState;
    }

    /**
     * @param applyState
     */
    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    /**
     * @return apply_reason
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * @param applyReason
     */
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason == null ? null : applyReason.trim();
    }
}
