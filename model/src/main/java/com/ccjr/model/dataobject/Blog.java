package com.ccjr.model.dataobject;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * blog
 * @author mybatis-generator
 */
@Data
public class Blog implements Serializable {
    private Integer bid;

    private String title;

    private Byte categoryId;

    private String description;

    private String content;

    private Date createDate;

    private Long visits;

    private Long comment;

    private Long star;

    private static final long serialVersionUID = 1L;
}