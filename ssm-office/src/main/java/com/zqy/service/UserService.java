package com.zqy.service;

import com.zqy.pojo.User;

public interface UserService {
    User login(String username, String password);
}
