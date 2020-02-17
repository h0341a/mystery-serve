package com.ccjr.dao;

import com.ccjr.model.dataobject.BlogCategory;

/**
 * @author mybatis-generator
 */
public interface BlogCategoryDao {
    int deleteByPrimaryKey(Byte id);

    int insert(BlogCategory record);

    int insertSelective(BlogCategory record);

    BlogCategory selectByPrimaryKey(Byte id);

    int updateByPrimaryKeySelective(BlogCategory record);

    int updateByPrimaryKey(BlogCategory record);
}