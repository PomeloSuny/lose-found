package com.example.losefound.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 11:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("users")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("account")
    private String account;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("gender")
    private Integer gender;

    @TableField("phone")
    private String phone;

    @TableField("del_flag")
    private Integer delFlag;
}
