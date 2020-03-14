package com.ccjr.api.admin;

import com.ccjr.model.dataobject.Comment;
import com.ccjr.response.BusinessException;
import com.ccjr.response.ErrorCodeEnum;
import com.ccjr.response.Result;
import com.ccjr.service.AdminCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ling
 */
@Api(tags = "博客后台评论管理接口")
@RestController
@RequestMapping("/api/admin/")
public class CommentController {

    private final AdminCommentService commentService;

    public CommentController(AdminCommentService adminCommentService) {
        this.commentService = adminCommentService;
    }

    @ApiOperation("获取评论列表")
    @GetMapping("/comments")
    public Result commentList(){
        //用户验证
        //CommentService获取结果
        return Result.ofSuccess(commentService.getCommentList());
        //返回
    }

    @ApiOperation("删除评论接口")
    @DeleteMapping("/comment/{cid}")
    public Result deleteComment(@PathVariable Integer cid){
        //用户验证
        //传入CommentService
        commentService.deleteComment(cid);
        //返回
        return Result.ofSuccess("删除成功");
    }

    @ApiOperation("管理员回复评论")
    @PostMapping("/comment/{cid}")
    public Result answerComment(@PathVariable Integer cid, String answerContent) throws BusinessException {
        //用户验证
        //参数校验
        if(StringUtils.isEmpty(answerContent)){
            return Result.ofFail(ErrorCodeEnum.PARAMETER_INVALID, "回复内容不能为空");
        }
        Comment comment = new Comment();
        comment.setNickname("作者本人");
        comment.setContent(answerContent);
        comment.setParentCid(cid);
        commentService.answerYouByMyAnswer(comment);
        //返回
        return Result.ofSuccess("添加成功");
    }
}
