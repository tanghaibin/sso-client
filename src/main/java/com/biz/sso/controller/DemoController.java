package com.biz.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haibin.tang
 * @create 2018-03-17 12:30
 **/
@Controller
@RequestMapping
public class DemoController {

    @RequestMapping("demo")
    public String demo() {
        return "demo";
    }
}
