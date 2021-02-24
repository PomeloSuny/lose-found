package com.example.losefound.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.losefound.common.ErrorInfo;
import com.example.losefound.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 11:20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from userinfo where username = #{username}")
    User findByName(String username);

    int addUser(User user);

}
