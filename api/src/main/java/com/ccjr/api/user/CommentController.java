package com.ccjr.api.user;

import com.ccjr.model.dataobject.Comment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "普通用户可以进行的评论操作")
@RestController
@RequestMapping("/api/user/")
public class CommentController {
    @ApiOperation("添加评论")
    @PostMapping("/blog/{bid}/comment")
    public void addComment(@PathVariable("bid") Integer bid, Comment comment){

    }

    @ApiOperation("删除评论")
    @DeleteMapping("/comment/{cid}")
    public void deleteComment(@PathVariable("cid") Integer cid){

    }

    @ApiOperation("回复评论")
    @DeleteMapping("/comment/{cid}/comment")
    public void answerComment(@PathVariable("cid") Integer cid, Comment comment){

    }

    @ApiOperation("获取某一博客下的全部评论")
    @GetMapping("/blog/{bid}/commentList")
    public void commentList(@PathVariable("bid") Integer bid){

    }

}
