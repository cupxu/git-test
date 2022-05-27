package com.cupxu.gittest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: cupxu
 * @create: 2022-05-26 14:32
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "测试成功";
    }
}
