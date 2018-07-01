package com.hxzhao.jetcachedemo.controller;

import com.hxzhao.jetcachedemo.service.IRefreshService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/refresh")
public class RefreshController {

    @Autowired
    private IRefreshService refreshService;

    @RequestMapping(path = "/time")
    public String refresh() {
        return refreshService.getContent();
    }

}
