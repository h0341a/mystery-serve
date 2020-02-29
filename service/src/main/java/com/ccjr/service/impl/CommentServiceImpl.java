package com.ccjr.service.impl;

import com.ccjr.dao.CommentDao;
import com.ccjr.model.dataobject.Comment;
import com.ccjr.model.vo.CommentVO;
import com.ccjr.service.AdminCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements AdminCommentService {

    private final CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
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
}
