package com.ccjr.dao;

import com.ccjr.model.dataobject.Comment;

/**
 * @author mybatis-generator
 */
public interface CommentDao {
    int deleteByPrimaryKey(Integer cid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}