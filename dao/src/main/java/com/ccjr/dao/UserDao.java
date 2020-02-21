package com.ccjr.dao;

import com.ccjr.model.dataobject.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author mybatis-generator
 */
@Repository
@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Byte uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Byte uid);
    User selectByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}