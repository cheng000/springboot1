package com.learn.springboot1.service;

import com.learn.springboot1.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Map<String,Object>> queryPerson1(Map<String,String>map) {
        return testMapper.queryPerson1(map);
    }

    @Override
    public String queryPerson2(Map<String, String> map) {
        return testMapper.queryPerson2(map);
    }

    @Override
    @Transactional
    public void insertPerson(List<Map<String,String>> personList) {
        testMapper.insertPerson(personList);
    }
}
