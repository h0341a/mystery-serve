package com.ccjr.api.admin;

import com.ccjr.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

/**
 * @author ling
 */
@Api(tags = "博客后台评论管理接口")
@RestController
@RequestMapping("/api/admin/")
public class CommentController {
    @ApiOperation("获取评论列表")
    @GetMapping("/comments")
    public Result commentList(){
        //用户验证
        //CommentService获取结果
        //返回
        return null;
    }

    @ApiOperation("删除评论接口")
    @DeleteMapping("/comment/{cid}")
    public Result deleteComment(@PathVariable Integer cid){
        //用户验证
        //传入CommentService
        //返回
        return null;
    }

    @ApiOperation("管理员回复评论")
    @PostMapping("/comment/{cid}")
    public Result answerComment(@PathVariable Integer cid, String answerContent){
        //用户验证
        //参数校验
        //传入CommentService
        //返回
        return null;
    }
}
