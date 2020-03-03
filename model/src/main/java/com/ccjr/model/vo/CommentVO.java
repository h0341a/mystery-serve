package com.ccjr.model.vo;

import com.ccjr.model.dataobject.Comment;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CommentVO{

    private Integer cid;
    private String nickname;
    private String email;
    private String content;
    private String blogTitle;
    private Date createDate;
    private List<CommentVO> children;

}
