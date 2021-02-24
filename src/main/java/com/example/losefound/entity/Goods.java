package com.example.losefound.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author: sunYue
 * @Date: 2021/2/23 14:08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("goods")
public class Goods {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 物品编号
     */
    @TableField("good_number")
    private String goodNumber;

    /**
     * 物品名称
     */
    @TableField("good_name")
    private String goodName;

    /**
     * 类型  1：丢失  2：捡到
     */
    @TableField("type")
    private Integer type;

    /**
     * 丢失or捡到物品的地点
     */
    @TableField("address")
    private String address;

    /**
     * 备注
     */
    @TableField("mark")
    private String mark;

    /**
     * 丢失时间
     */
    @TableField("lose_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loseTime;

    /**
     * 发现时间
     */
    @TableField("find_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime findTime;

    /**
     * 归还时间
     */
    @TableField("give_back_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime giveBackTime;

    /**
     * 删除标志
     */
    @TableField("del_flag")
    private Integer delFlag;

}
