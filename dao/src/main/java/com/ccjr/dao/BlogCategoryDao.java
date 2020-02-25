package com.ccjr.dao;

import com.ccjr.model.dataobject.BlogCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author mybatis-generator
 */
@Repository
@Mapper
public interface BlogCategoryDao {
    int deleteByPrimaryKey(Byte id);

    int insert(BlogCategory record);

    int insertSelective(BlogCategory record);

    BlogCategory selectByPrimaryKey(Byte id);

    /**
     * 根据分组名获取分组id
     * @param categoryName 分组名
     * @return 分组id
     */
    Integer selectIdByName(String categoryName);

    int updateByPrimaryKeySelective(BlogCategory record);

    int updateByPrimaryKey(BlogCategory record);
}