package com.ccjr.api;

import com.ccjr.response.BusinessException;
import com.ccjr.response.ErrorCodeEnum;
import com.ccjr.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ling
 */
@RestController
@RequestMapping("/testException")
public class ExceptionTestController {
    @GetMapping("/1")
    public Result exception1(){
        int i = 2 / 0;
        return null;
    }
    @GetMapping("/2")
    public Result exception2() throws BusinessException {
        throw new BusinessException(ErrorCodeEnum.UNKNOWN_ERROR, "自定义提示信息");
    }
}
