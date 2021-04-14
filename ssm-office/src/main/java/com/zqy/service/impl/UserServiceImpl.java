package com.zqy.service.impl;

import com.zqy.mapper.UserMapper;
import com.zqy.pojo.User;
import com.zqy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String  password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("loginName",username);
        criteria.andEqualTo("password",password);
        return userMapper.selectOneByExample(example);
    }
}
