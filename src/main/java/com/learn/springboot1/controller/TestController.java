package com.learn.springboot1.controller;

import com.learn.springboot1.entity.Person;
import com.learn.springboot1.service.TestService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Character.getType;

@RestController
@RequestMapping("/hello")
public class TestController {
    @Autowired
    private TestService testService;
    private static String[] mm = {"2","4"};
    private static String[] tests = {"2","4"};

    boolean checkString(String ... ss) {
        for(String s : ss){
            if(StringUtils.isEmpty(s)) {
                return false;
            }
        }
        return true;
    }

    public static int getWordCount(String s)
    {
        int length = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int ascii = Character.codePointAt(s, i);
            if(ascii >= 0 && ascii <=255){
                length++;}
            else{
                length += 2;}

        }
        return length;

    }


    @ApiOperation(value="swagger测试")
    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    @ApiImplicitParam(name = "id",value = "人员id",required = true)
    @ResponseBody
    public List<Map<String,Object>> test1(@RequestBody Map<String,String>inMap){

        String[] teststr = {"",""};
        teststr[0] = "a";
        teststr[1] = "b";
        System.out.println(teststr[0]);

        //int test = 1 / 0;

        if("2"!= tests[0] && "2" != tests[1]){
            System.out.println(tests[0]);
            System.out.println(tests[1]);
        }
        System.out.println("==="+tests[0]);
        System.out.println("==="+tests[1]);


        int n = 500 > 2000 ? 1 : 2;
        System.out.println(n);

        String s1 = "";
        String s2 = "1";
        String s3 = null;

        System.out.println(checkString(s2));

        System.out.println(getWordCount("123你的"));



        System.out.println(mm[1]);
        List<Map<String,Object>> returnList = testService.queryPerson1(inMap);
        System.out.println(returnList.getClass().getName());
        for(int i= 0;i<returnList.size();i++){
            Map<String,Object>listMap = returnList.get(i);
            Set<String>set = listMap.keySet();
            for(String key:set){
                System.out.println(key);
                listMap.put(key,"new");
            }
        }

        String ss = "12345678";
        System.out.println(ss.substring(ss.length()-8,ss.length()));
        String[] m = {"a","b","c"};
        for(String mm : m) {
            if(mm.equals("b")){
                continue;
            }
            System.out.println(mm);
        }

        int i = 0;
        System.out.println("********"+getType(i));


        Date date = new Date();
        long time = date.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateString = simpleDateFormat.format(time);
        System.out.println(dateString);
        return returnList;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public HashMap<String,Object> test2(@RequestBody @Valid Person person, BindingResult results){

        Map<String,String>testMap = new HashMap<>();
        testMap.put("A","1");
        testMap.remove("RN");
        /*String s = null;
        if(s != null && s.length() < 2) {
            System.out.println("小于2");
        }else{
            System.out.println(s.length());
        }*/
        HashMap<String,Object>resultMap = new HashMap<>();
        Map<String,Object>returnMap = new HashMap<>();
        if (results.hasErrors()) {
            returnMap.put("code","-1");
            returnMap.put("msg",results.getFieldError().getDefaultMessage());
            resultMap.put("result",returnMap);
            return resultMap;
        }
        Map<String,String>inMap = new HashMap<>();
        inMap.put("id",person.getId());
        try {
            returnMap.put("person",testService.queryPerson2(inMap));
            returnMap.put("code","0");
            resultMap.put("result",returnMap);
        }catch (Exception e){
            System.out.println(e);
        }
        return resultMap;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public void insertPerson(@RequestBody List<Map<String,String>> personList){
        HashMap<String,Object>resultMap = new HashMap<>();


        testService.insertPerson(personList);
    }



}