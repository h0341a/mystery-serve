package com.ccjr.service;

import com.ccjr.model.dto.CommentDTO;
import com.ccjr.response.BusinessException;

public interface UserCommentService {

    /**
     * 添加新的评论
     * @param bid 博客id
     * @param commentDTO 评论内容
     */
    public void addNewComment(Integer bid, CommentDTO commentDTO) throws BusinessException;

}
