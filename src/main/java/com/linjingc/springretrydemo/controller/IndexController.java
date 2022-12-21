package com.linjingc.springretrydemo.controller;

import com.linjingc.springretrydemo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping("index")
    public String test() {
        return indexService.test();
    }
}
