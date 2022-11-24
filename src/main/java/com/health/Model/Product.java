package com.health.Model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@TableName("product")
public class Product implements Serializable {

    @TableId(value = "pid",type = IdType.AUTO)
    private int pid;

    @TableField(value = "name")
    private String name;

    @TableField(value = "price")
    private BigDecimal price;


    private  String text;

    private String level;




}
