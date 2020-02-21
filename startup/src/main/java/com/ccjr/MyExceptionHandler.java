package com.ccjr;

import com.ccjr.response.BusinessException;
import com.ccjr.response.ErrInfoInterface;
import com.ccjr.response.ErrorCodeEnum;
import com.ccjr.response.Result;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author ling
 */
@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler
    public Result exceptionHandler(Exception e) {
        if (e instanceof BusinessException) {
            return Result.ofFail(((BusinessException) e).getErrInfo());
        } else if (e instanceof BindException) {
            //使用validator校验参数失败后的异常
            return Result.ofFail(ErrorCodeEnum.PARAMETER_INVALID, Objects.requireNonNull(((BindException) e).getBindingResult().getFieldError()).getDefaultMessage());
        } else {
            return Result.ofFail(ErrorCodeEnum.UNKNOWN_ERROR, e.getMessage());
        }
    }

}
