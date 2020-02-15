package com.ccjr.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ling
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello, the multi module project.";
    }
}
