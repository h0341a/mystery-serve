package com.ccjr.service.impl;

import com.ccjr.dao.BlogDao;
import com.ccjr.dao.CommentDao;
import com.ccjr.model.dataobject.Comment;
import com.ccjr.model.dto.CommentDTO;
import com.ccjr.model.vo.CommentVO;
import com.ccjr.response.BusinessException;
import com.ccjr.response.ErrorCodeEnum;
import com.ccjr.service.AdminCommentService;
import com.ccjr.service.UserCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements AdminCommentService, UserCommentService {

    private final CommentDao commentDao;
    private final BlogDao blogDao;

    public CommentServiceImpl(CommentDao commentDao, BlogDao blogDao) {
        this.commentDao = commentDao;
        this.blogDao = blogDao;
    }

    @Override
    public List<CommentVO> getCommentList() {
        //获取所有的父评论
        List<Comment> commentList = commentDao.selectByParentId(0);
        return null;
    }

    @Override
    public void AnswerYouByMyAnswer(Integer cid) {

    }

    @Override
    public List<CommentVO> getCommentListByBid(Integer bid) {
        return null;
    }

    private CommentVO convertComment(Comment comment){
        return null;
    }

    @Override
    public void addNewComment(Integer bid, CommentDTO commentDTO) throws BusinessException {
        if(blogDao.selectByPrimaryKey(bid) == null){
            throw new BusinessException(ErrorCodeEnum.DATA_ABORT, "没有该博客");
        }
        Comment comment = this.convertCommentDTO(bid, commentDTO);
        if(commentDao.insertSelective(comment) != 1){
            throw new BusinessException(ErrorCodeEnum.DB_OPERATION_FAIL, "添加评论失败");
        }
    }

    private Comment convertCommentDTO(Integer bid, CommentDTO commentDTO){
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setBlogId(bid);
        return comment;
    }
}
