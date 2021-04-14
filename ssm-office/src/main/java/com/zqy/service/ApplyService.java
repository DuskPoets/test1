package com.zqy.service;

import com.github.pagehelper.PageInfo;
import com.zqy.pojo.Apply;

import java.util.List;

public interface ApplyService {
    int addApply(Apply apply);

    PageInfo<Apply> getPage(Integer pageSize, Integer pageNum, String articleName, Integer articleType,Integer userId);

    int setState(Integer applyId,Integer state);

    Apply getApply(Integer revokeId);

    int updateApply(Apply apply);

    PageInfo getAuditPage(Integer pageNum, Integer pageSize, String userName, String applyDate);
}
