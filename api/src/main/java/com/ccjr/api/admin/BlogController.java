package com.ccjr.api.admin;

import com.ccjr.model.dto.BlogDTO;
import com.ccjr.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author ling
 */
@Api("后台博客管理接口")
@RestController
@RequestMapping("/api/admin/")
public class BlogController {
    @ApiOperation("获取博客列表")
    @GetMapping("/blogList")
    public Result blogList(){
        //用户验证
        //blogService获取结果
        //返回
        return null;
    }

    @ApiOperation("创建一个新博客")
    @PostMapping("/blog")
    public Result newBlog(BlogDTO blogDTO){
        //用户验证
        //将blogDTO传入到service
        //返回结果
        return null;
    }

    @ApiOperation("删除一个博客")
    @DeleteMapping("/blog/{bid}")
    public Result deleteBlog(@PathVariable("bid") Integer bid){
        //用户验证
        //传入到service
        //返回结果
        return null;
    }

    @ApiOperation("编辑一个博客")
    @PutMapping("/blog/{bid}")
    public Result alterBlog(@PathVariable("bid") Integer bid, BlogDTO blogDTO){
        //用户验证
        //传入service
        //返回结果
        return null;
    }
}
