package com.ccjr.api.admin;

import com.ccjr.model.dto.UserDTO;
import com.ccjr.response.BusinessException;
import com.ccjr.response.ErrorCodeEnum;
import com.ccjr.response.Result;
import com.ccjr.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

/**
 * @author ling
 */
@Api(tags = "管理员登录管理")
@RestController
@RequestMapping("/api/admin/user")
public class UserController {

    private final HttpServletRequest req;
    private final UserService userService;

    public UserController(HttpServletRequest req, UserService userService) {
        this.req = req;
        this.userService = userService;
    }

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public Result login(@Valid UserDTO userDTO) throws BusinessException, NoSuchAlgorithmException {
        int uid = userService.userVerify(userDTO);
        req.getSession().setAttribute("uid", uid);
        return Result.ofSuccess("登录成功");
    }

    @ApiOperation("用户注销接口")
    @GetMapping("/logout")
    public Result logout() {
        Object uid = req.getSession().getAttribute("uid");
        if (uid != null) {
            req.getSession().invalidate();
            return Result.ofSuccess("用户注销成功");
        } else {
            return Result.ofFail(ErrorCodeEnum.USER_NOT_LOGIN);
        }
    }
}
