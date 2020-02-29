package com.ccjr.model.vo;

import com.ccjr.model.dataobject.Comment;
import lombok.Data;

import java.util.List;

@Data
public class CommentVO {

    private Integer cid;
    private String content;
    private String blogTitle;
    private String nickName;
    private String email;
    private Data createDate;
    private List<CommentVO> children;

}
