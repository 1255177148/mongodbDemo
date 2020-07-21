package com.mongodb.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.demo.service.MongodbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2020/7/20 17:32
 * @Author hezhan
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private MongodbService mongodbService;

    @GetMapping("/save")
    public void testSave(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "贺瞻");
        jsonObject.put("sex", "男");
        mongodbService.insertData(jsonObject);
    }

    @GetMapping("/get")
    public String get(@RequestParam("name") String name){
        JSONObject jsonObject = mongodbService.getData(name);
        return JSON.toJSONString(jsonObject);
    }
}
