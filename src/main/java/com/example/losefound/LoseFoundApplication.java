package com.example.losefound;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
@SpringBootApplication
@MapperScan({"com.example.losefound.dao"})
public class LoseFoundApplication {

    private final Logger log = LoggerFactory.getLogger(LoseFoundApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoseFoundApplication.class, args);
    }

//    @RequestMapping(value = "/hello")
//    public @ResponseBody String hello(){
//        log.info("Hello world log test---");
//        return "Hello world!";
//    }

}
