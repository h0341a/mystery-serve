package com.ccjr.dao;

import com.ccjr.model.dataobject.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mybatis-generator
 */
@Repository
@Mapper
public interface BlogDao {
    int deleteByPrimaryKey(Integer bid);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer bid);
    List<Blog> selectAll();
    List<Blog> selectByCategoryId(Integer categoryId);
    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
}