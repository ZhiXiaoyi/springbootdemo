package com.example.springbootdemo.controller;

import com.example.springbootdemo.biz.dao.PersonDao;
import com.example.springbootdemo.biz.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectRedisController {

    protected static Logger logger= LoggerFactory.getLogger(ObjectRedisController.class);

    @Autowired
    PersonDao personDao;

    @RequestMapping("/setPerson")
    public String set(Integer id,String name,Integer age,String address){
        logger.info("访问setPerson:id={},name={},age={},address={}",id,name,age,address);
        Person person=new Person(id,name,age,address);
        personDao.save(person);
        return "save ok";
    }

    @RequestMapping("/getPerson")
    public Person getPerson(String id){
        return personDao.getPerson(id);
    }
}
