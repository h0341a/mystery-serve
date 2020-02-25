package com.ccjr.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BlogVO {
    private Integer bid;
    private String title;
    private String category;
    private String description;
    private String content;
    private Date createDate;
    //浏览博客页面会用到的属性
    private Long visits;
    private Long comment;
    private Long star;
}
