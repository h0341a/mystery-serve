package com.ccjr.api.admin;

import com.ccjr.model.dto.UserDTO;
import com.ccjr.response.ErrorCodeEnum;
import com.ccjr.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ling
 */
@Api(tags = "后台用户管理")
@RestController
@RequestMapping("/api/admin/user")
public class UserController {

    private final HttpServletRequest req;

    public UserController(HttpServletRequest req) {
        this.req = req;
    }

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public Result login(@Validated UserDTO userDTO){
        return Result.ofSuccess("");
    }

    @ApiOperation("用户注销接口")
    @GetMapping("/logout")
    public Result logout(){
        Object uid = req.getSession().getAttribute("uid");
        if (uid != null){
            req.getSession().invalidate();
            return Result.ofSuccess("用户注销成功");
        }else{
            return Result.ofFail(ErrorCodeEnum.USER_NOT_LOGIN);
        }
    }
}
