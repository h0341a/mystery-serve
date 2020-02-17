package com.ccjr.dao;

import com.ccjr.model.dataobject.User;

/**
 * @author mybatis-generator
 */
public interface UserDao {
    int deleteByPrimaryKey(Byte uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Byte uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}