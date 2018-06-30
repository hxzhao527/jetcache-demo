package com.hxzhao.jetcachedemo.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.hxzhao.jetcachedemo.mapper.UserMapper;
import com.hxzhao.jetcachedemo.model.User;
import com.hxzhao.jetcachedemo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Cached(name = "userCache.", key = "'userList'", expire = 300, cacheType = CacheType.BOTH)
    public List<User> getAll() {
        return userMapper.getAllUser();
    }

    @Override
    @CacheUpdate(name = "userCache", key = "#user.userId", value = "#user")
    @CacheInvalidate(name = "userCache.", key = "'userList'")
    @Transactional
    public void updateUser(User user) {
        userMapper.update(user);
    }

    @Override
    //@Cached(name = "userCache", key = "#userId", expire = 300, cacheType = CacheType.BOTH)
    @CacheInvalidate(name = "userCache.", key = "'userList")
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    @Cached(name = "userCache", key = "#userId", expire = 300, cacheType = CacheType.BOTH)
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
