package com.zqy.mapper;

import com.zqy.pojo.Apply;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ApplyMapper extends Mapper<Apply> {


    List<Apply> selectList(@Param("articleName") String articleName,
                           @Param("articleType") Integer articleType,
                           @Param("userId") Integer userId);

    Apply selectById(Integer revokeId);

    List selectAuditList(@Param("userName") String userName,
                         @Param("applyDate") String applyDate);
}
