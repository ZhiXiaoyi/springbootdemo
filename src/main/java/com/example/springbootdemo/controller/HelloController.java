package com.example.springbootdemo.controller;

import com.example.springbootdemo.biz.entity.RandomProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private  RandomProperties randomProperties;

    @Value("${com.waiting.custom.one}")
    private String stringOne;
    @Value("${com.waiting.custom.two}")
    private String stringTwo;
    @Value("${com.waiting.custom.three}")
    private Integer integerThree;

    @RequestMapping(value = "/",name = "Hello")
    public String testHello(){
        logger.info("logback-ok");

        return "Hello Spring-boot！"+stringOne+stringTwo+integerThree+"\r"+randomProperties;
    }

    @RequestMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        logger.debug("访问helloName,Name={}",name);
        return "Hello "+name;
    }
}
