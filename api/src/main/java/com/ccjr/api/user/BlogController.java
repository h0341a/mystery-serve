package com.ccjr.api.user;

import com.ccjr.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "普通用户可以对博客进行的操作")
@RestController
@RequestMapping("/api/user/")
public class BlogController {

    /**
     * 获取分组列表
     * @return 返回分组列表
     */
    @ApiOperation("分组列表")
    @GetMapping("/categoryList")
    public Result categoryList(){
        return null;
    }

    /**
     * 根据分组名获取博客列表
     * @param categoryName 分类名
     * @return 博客列表
     */
    @ApiOperation("根据分组名获取博客列表")
    @GetMapping("/blogList/{category}")
    public Result blogListByCategory(@PathVariable("category") String categoryName){
        return null;
    }
    @ApiOperation("根据博客id获取博客内容")
    @GetMapping("/blog/{bid}")
    public Result blog(@PathVariable("bid") Integer bid){
        return null;
    }

}
