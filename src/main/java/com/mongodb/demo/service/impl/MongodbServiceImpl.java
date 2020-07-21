package com.mongodb.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.demo.service.MongodbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @Date 2020/7/20 10:13
 * @Author hezhan
 */
@Service
public class MongodbServiceImpl implements MongodbService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertData(JSONObject jsonObject) {
        mongoTemplate.save(jsonObject);
//        mongoTemplate.insert(jsonObject);
    }

    @Override
    public JSONObject getData(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, JSONObject.class);
    }
}
