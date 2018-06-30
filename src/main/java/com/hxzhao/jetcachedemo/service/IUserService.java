package com.hxzhao.jetcachedemo.service;

import com.hxzhao.jetcachedemo.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    void updateUser(User user);

    void insertUser(User user);

    User getUserById(Integer userId);
}
