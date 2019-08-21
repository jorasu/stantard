package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.service.StandardService;
import com.kgc.vo.Standard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by jora on 2019/6/18.
 */
@RestController
public class StandardController {
    @Resource
    private StandardService service;
    @RequestMapping("/query.do")
    PageInfo<Map<String,Object>> query(@RequestParam(defaultValue = "1") Integer pNo, @RequestParam(defaultValue = "2") Integer pSize, String title){
        return service.query(pNo,pSize,title);
    };
    @RequestMapping("/queryById.do")
    Map<String,Object> queryById(Integer id){
        return service.queryById(id);
    };
    @RequestMapping("/add.do")
    String add(Standard standard){
        return service.add(standard);
    };
    @RequestMapping("/update.do")
    int update(Standard standard){
        return service.update(standard);
    };
    @RequestMapping("/del.do")
    int del(Integer id){
        return service.del(id);
    };
}
