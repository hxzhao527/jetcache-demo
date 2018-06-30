package com.hxzhao.jetcachedemo.controller;

import com.hxzhao.jetcachedemo.model.User;
import com.hxzhao.jetcachedemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> listUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    /**
     * 根据ID查询
     *
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> getUserInfo(@RequestParam() Integer id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    /**
     * 更新
     *
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")

    public ResponseEntity<Object> updateUserInfo(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        User user = new User();
        user.setUserId(id);
        user.setUserName(name);
        userService.updateUser(user);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * 插入
     *
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> insertUser(@RequestParam() String name) {
        User user = new User();
        user.setUserName(name);
        user.setCreateTime(new Date());
        userService.insertUser(user);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
