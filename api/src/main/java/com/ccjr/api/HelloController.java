package com.ccjr.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ling
 */
@RestController
@Api(tags = "hello")
public class HelloController {
    @ApiOperation("print hello")
    @GetMapping("/hello")
    public String hello() {
        return "hello, the multi module project.";
    }
}
