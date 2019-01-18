package com.ccnt.news.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping(value="/hello")
    @ResponseBody
    public String index(){
        return "Hello Spring Boot";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
        //运行之后在浏览器中访问：http://localhost:8080/hello
    }
}
