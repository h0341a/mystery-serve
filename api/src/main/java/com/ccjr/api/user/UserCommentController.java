package com.ccjr.api.user;

import com.ccjr.model.dataobject.Comment;
import com.ccjr.model.dto.CommentDTO;
import com.ccjr.response.BusinessException;
import com.ccjr.response.Result;
import com.ccjr.service.UserCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "普通用户可以进行的评论操作")
@RestController
@RequestMapping("/api/user/")
public class UserCommentController {

    private final UserCommentService commentService;

    public UserCommentController(UserCommentService userCommentService) {
        this.commentService = userCommentService;
    }

    @ApiOperation("添加评论")
    @PostMapping("/blog/{bid}/comment")
    public Result addComment(@PathVariable("bid") Integer bid, @Validated CommentDTO commentDTO) throws BusinessException {
        commentService.addNewComment(bid, commentDTO);
        return Result.ofSuccess("提交成功");
    }

    @ApiOperation("回复评论")
    @PostMapping("/comment/{cid}/comment")
    public Result answerComment(@PathVariable("cid") Integer cid, @Validated CommentDTO commentDTO) throws BusinessException {
        commentService.answerComment(cid, commentDTO);
        return Result.ofSuccess("回复成功");
    }

    @ApiOperation("获取某一博客下的全部评论")
    @GetMapping("/blog/{bid}/commentList")
    public Result commentList(@PathVariable("bid") Integer bid){
        return Result.ofSuccess(commentService.getCommentListByBlogId(bid));
    }

}
