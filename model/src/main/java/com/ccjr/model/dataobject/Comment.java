package com.ccjr.model.dataobject;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * comment
 * @author mybatis-generator
 */
@Data
public class Comment implements Serializable {
    private Integer cid;

    private String nickname;

    private String email;

    private String content;

    private Integer blogId;

    private Integer starCount;

    private Integer parentCid;

    private Date createDate;

    private static final long serialVersionUID = 1L;
}