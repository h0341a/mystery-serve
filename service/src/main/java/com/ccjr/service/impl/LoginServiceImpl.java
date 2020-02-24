package com.ccjr.service.impl;

import com.ccjr.dao.UserDao;
import com.ccjr.model.dataobject.User;
import com.ccjr.model.dto.UserDTO;
import com.ccjr.response.BusinessException;
import com.ccjr.response.ErrorCodeEnum;
import com.ccjr.service.AdminLoginService;
import com.ccjr.utils.PasswordUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * @author ling
 */
@Service
public class LoginServiceImpl implements AdminLoginService {
    private final UserDao userDao;

    public LoginServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int loginVerify(UserDTO userDTO) throws NoSuchAlgorithmException, BusinessException {
        User userDb = userDao.selectByUsername(userDTO.getUsername());
        //判断数据库中的密码是否为空且是否与用户输入的是否匹配.
        if (userDb != null &&
                StringUtils.equals(userDb.getPassword(), PasswordUtils.toMd5Code(userDTO.getPassword()))) {
            return userDb.getUid();
        }
        throw new BusinessException(ErrorCodeEnum.USER_VERIFY_FAIL, "账号或密码错误");
    }
}
