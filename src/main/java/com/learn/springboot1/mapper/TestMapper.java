package com.learn.springboot1.mapper;

import java.util.List;
import java.util.Map;

/*@Mapper
public interface TestMapper {
    @Select("select * from person where id = #{id}")
    List<Person> queryPerson1(Map<String,String>map);

    @Select("select * from person where id = #{id}")
    Person queryPerson2(Map<String,String>map);

    @Insert("insert into person(id,name,age)values(#{id},#{name},#{age})")
    int insertPerson(Map<String,String>map);
}*/

public interface TestMapper {

    List<Map<String,Object>> queryPerson1(Map<String,String>map);

    String queryPerson2(Map<String,String>map);

    void insertPerson(List<Map<String,String>> personList);
}
