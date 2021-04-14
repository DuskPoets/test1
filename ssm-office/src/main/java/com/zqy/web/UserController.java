package com.zqy.web;

import com.zqy.pojo.User;
import com.zqy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        if (user==null){
            return null;
        }
        String loginName = user.getLoginName();
        if (loginName == null && loginName.equals("")){
            return null;
        }
        User login = userService.login(loginName, user.getPassword());
        if (login!=null){
            return ResponseEntity.ok(login);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
