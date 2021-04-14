package com.zqy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zqy.mapper.ApplyMapper;
import com.zqy.mapper.ArticleMapper;
import com.zqy.pojo.Apply;
import com.zqy.pojo.Article;
import com.zqy.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;
    @Override
    public int addApply(Apply apply) {
        return applyMapper.insertSelective(apply);
    }

    @Override
    public PageInfo<Apply> getPage(Integer pageSize, Integer pageNum, String articleName,
                                   Integer articleType,Integer userId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Apply> applies = applyMapper.selectList(articleName,articleType,userId);
        return new PageInfo<>(applies);
    }

    @Override
    public int setState(Integer applyId,Integer state) {
        Apply apply = new Apply();
        apply.setApplyState(state);
        apply.setApplyId(applyId);
        return applyMapper.updateByPrimaryKeySelective(apply);
    }

    @Override
    public Apply getApply(Integer revokeId) {
        return applyMapper.selectById(revokeId);
    }

    @Override
    public int updateApply(Apply apply) {
        return applyMapper.updateByPrimaryKeySelective(apply);
    }

    @Override
    public PageInfo getAuditPage(Integer pageNum, Integer pageSize, String userName, String applyDate) {
        PageHelper.startPage(pageNum,pageSize);
        List list = applyMapper.selectAuditList(userName,applyDate);
        return new PageInfo<>(list);
    }
}
