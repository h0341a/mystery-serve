package com.ccjr.dao;

import com.ccjr.model.dataobject.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mybatis-generator
 */
@Repository
@Mapper
public interface CommentDao {
    int deleteByPrimaryKey(Integer cid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer cid);
    List<Comment> selectByParentId(Integer parentId);
    List<Comment> selectByBlogId(Integer blogId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}