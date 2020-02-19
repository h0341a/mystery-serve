package com.ccjr;

import com.ccjr.response.BusinessException;
import com.ccjr.response.ErrInfoInterface;
import com.ccjr.response.ErrorCodeEnum;
import com.ccjr.response.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ling
 */
@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler
    public Result exceptionHandler(Exception e){
        if (e instanceof BusinessException){
            return Result.ofFail(((BusinessException) e).getErrInfo());
        }else{
            return Result.ofFail(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }
}
