package com.ccjr.dao;

import com.ccjr.model.dataobject.Blog;

/**
 * @author mybatis-generator
 */
public interface BlogDao {
    int deleteByPrimaryKey(Integer bid);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
}