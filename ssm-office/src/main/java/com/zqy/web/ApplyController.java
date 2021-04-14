package com.zqy.web;

import com.github.pagehelper.PageInfo;
import com.zqy.mapper.ApplyMapper;
import com.zqy.pojo.Apply;
import com.zqy.pojo.Article;
import com.zqy.service.ApplyService;
import com.zqy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("apply")
@CrossOrigin
public class ApplyController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private ArticleService articleService;
    @PostMapping
    public ResponseEntity addApply(@RequestBody Apply apply){
        Integer applyNum = apply.getApplyNum();
        Integer articleId = apply.getArticleId();
        Article article = articleService.getArticle(articleId);
        article.setStockNum(article.getStockNum()-applyNum);
        articleService.updateArticle(article);
        apply.setApplyState(0);
        int a = applyService.addApply(apply);
        if (a>0) {
            return ResponseEntity.ok(a);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping(value = {"/page/{pageSize}/{pageNum}/{userId}",
            "/page/name/{pageSize}/{pageNum}/{articleName}/{userId}",
            "/page/type/{pageSize}/{pageNum}/{articleType}/{userId}",
            "/page/{pageSize}/{pageNum}/{articleName}/{articleType}/{userId}"
    })
    public ResponseEntity getPage(@PathVariable Integer pageSize,
                                  @PathVariable Integer pageNum,
                                  @PathVariable(value = "articleName",required = false) String articleName,
                                  @PathVariable(value = "articleType",required = false) Integer articleType,
                                  @PathVariable Integer userId){
        PageInfo<Apply> page = applyService.getPage(pageSize,pageNum,articleName,articleType,userId);
        if (page!=null){
            return ResponseEntity.ok(page);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping
    public ResponseEntity revoke(@RequestBody List<Integer> revokeIds){
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer revokeId : revokeIds) {
           Apply apply = applyService.getApply(revokeId);
            Integer articleId = apply.getArticleId();
            Article article = articleService.getArticle(articleId);
            article.setStockNum(article.getStockNum()+apply.getApplyNum());
            articleService.updateArticle(article);
            int i = applyService.setState(revokeId, 2);
            list.add(i);
        }
        if (list!=null){
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("{id}")
    public ResponseEntity getApply(@PathVariable Integer id){
        Apply apply = applyService.getApply(id);
        if (apply!=null){
            return ResponseEntity.ok(apply);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PutMapping("/one")
    public ResponseEntity updateApply(@RequestBody Apply apply){
        Integer articleId = apply.getArticleId();
        Article article = articleService.getArticle(articleId);
        article.setStockNum(article.getStockNum()-apply.getApplyNum());
        articleService.updateArticle(article);
        apply.setApplyState(0);
        int a = applyService.updateApply(apply);
        if (a > 0){
            return ResponseEntity.ok(a);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping(value = {"/audit/page/{pageSize}/{pageNum}",
            "/audit/page/username/{pageSize}/{pageNum}/{username}",
            "/audit/page/date/{pageSize}/{pageNum}/{applyDate}",
            "/audit/page/{pageSize}/{pageNum}/{username}/{applyDate}"})
    public ResponseEntity page(@PathVariable Integer pageSize,
                               @PathVariable Integer pageNum,
                               @PathVariable(value = "username",required = false) String userName,
                               @PathVariable(value = "applyDate",required = false) String applyDate){
        PageInfo page = applyService.getAuditPage(pageNum,pageSize,userName,applyDate);
        if (page!=null){
            return ResponseEntity.ok(page);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
    @PutMapping("/pass")
    public ResponseEntity passApply(@RequestBody List<Integer> ids){
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer id : ids) {
            int i = applyService.setState(id, 1);
            list.add(i);
        }
        if (list!=null){
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PutMapping("/revoke")
    public ResponseEntity revokeApply(@RequestBody List<Integer> ids){
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer id : ids) {
            Apply apply = applyService.getApply(id);
            Integer articleId = apply.getArticleId();
            Article article = articleService.getArticle(articleId);
            article.setStockNum(article.getStockNum()+apply.getApplyNum());
            articleService.updateArticle(article);
            int i = applyService.setState(id,-1);
            list.add(i);
        }
        if (list!=null){
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
