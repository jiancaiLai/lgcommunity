package com.gdlgxy.lgcommunity.entity;

import lombok.Data;

import java.util.Date;

@Data // 生成getter、setter、toString、[hashcode、equals]等方法
public class DiscussPost {
    private int id;
    private int userId;
    private String title;
    private String content;
    private int type;
    private int status;
    private Date createTime;
    private int commentCount;
    private double score;
}
