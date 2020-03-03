package com.ccjr.service;

import com.ccjr.model.dataobject.Comment;
import com.ccjr.model.dto.CommentDTO;
import com.ccjr.model.vo.CommentVO;
import com.ccjr.response.BusinessException;

import java.util.List;

public interface UserCommentService {

    /**
     * 添加新的评论
     * @param bid 博客id
     * @param commentDTO 评论内容
     */
    public void addNewComment(Integer bid, CommentDTO commentDTO) throws BusinessException;

    /**
     * 对某一评论进行回复
     * @param cid 评论id
     * @param commentDTO 评论内容
     */
    public void answerComment(Integer cid, CommentDTO commentDTO) throws BusinessException;

    /**
     * 根据博客id获取评论列表
     * @param bid 博客id
     * @return 评论列表
     */
    public List<CommentVO> getCommentListByBlogId(Integer bid);

}
