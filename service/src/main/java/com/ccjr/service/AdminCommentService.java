package com.ccjr.service;

import com.ccjr.model.dataobject.Comment;
import com.ccjr.model.vo.CommentVO;
import com.ccjr.response.BusinessException;

import java.util.List;

/**
 * @author ling
 */
public interface AdminCommentService {

    /**
     * 获取所有评论列表
     * @return 评论列表
     */
    public List<CommentVO> getCommentList();
    
    /**
     * 回复某一评论
     * @param comment 评论信息
     * @throws  BusinessException 业务异常
     */
    public void answerYouByMyAnswer(Comment comment) throws BusinessException;

    /**
     * 根据博客id获取评论列表
     * @param bid 博客id
     * @return 评论列表
     */
    public List<CommentVO> getCommentListByBid(Integer bid);

    /**
     * 删除评论
     * @param cid 评论id
     */
    public void deleteComment(Integer cid);
}
