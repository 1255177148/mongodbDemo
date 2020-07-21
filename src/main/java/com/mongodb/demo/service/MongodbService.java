package com.mongodb.demo.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Date 2020/7/20 10:12
 * @Author hezhan
 */
public interface MongodbService {

    /**
     * 将json对象保存到mongodb
     * @param jsonObject
     */
    void insertData(JSONObject jsonObject);

    /**
     * 根据名称查询数据
     * @param name
     * @return
     */
    JSONObject getData(String name);
}
