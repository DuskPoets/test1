package com.zqy.web;

import com.zqy.pojo.ArticleType;
import com.zqy.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("articleType")
@CrossOrigin
public class ArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;
    @GetMapping("articleTypes")
    public ResponseEntity findAll(){
        List<ArticleType> all = articleTypeService.findAll();
        if (all!=null){
            return ResponseEntity.ok(all);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
