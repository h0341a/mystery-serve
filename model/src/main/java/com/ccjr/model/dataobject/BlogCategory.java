package com.ccjr.model.dataobject;

import java.io.Serializable;
import lombok.Data;

/**
 * blog_category
 * @author mybatis-generator
 */
@Data
public class BlogCategory implements Serializable {
    private Byte id;

    private String name;

    private String description;

    private static final long serialVersionUID = 1L;
}