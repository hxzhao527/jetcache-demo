package com.hxzhao.jetcachedemo.mapper;

import com.hxzhao.jetcachedemo.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    @Results(id = "userMap", value = {@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "name", property = "userName", jdbcType = JdbcType.VARCHAR),

    })
    List<User> getAllUser();


    @Select(value = "select user_id, name, create_time from user where user_id = #{userId,jdbcType=INTEGER}")
    @ResultMap("userMap")
    User selectByPrimaryKey(Integer userId);

    @Insert(value = "insert into user (name, create_time) values (#{userName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})")
    int insert(User user);

    @Update(value = "update user set name = #{userName,jdbcType=VARCHAR} where user_id = #{userId,jdbcType=INTEGER}")
    int update(User user);

}
