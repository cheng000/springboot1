package com.learn.springboot1.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TestService {

    List<Map<String,Object>> queryPerson1(Map<String,String>map);

    String queryPerson2(Map<String,String>map);

    void insertPerson(List<Map<String,String>> personList);
}
