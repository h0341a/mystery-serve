package com.ccjr.dao;

import com.ccjr.model.dataobject.User;
import org.springframework.stereotype.Repository;

/**
 * @author mybatis-generator
 */
@Repository
public interface UserDao {
    int deleteByPrimaryKey(Byte uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Byte uid);
    User selectByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}