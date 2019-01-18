package com.ccnt.news.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

//
//@RequestMapping("/static/")
//@Controller
//
//    @RequestMapping("{page}")
//    public String re(@PathVariable("page")String page){
//        return page;
//    }
//}

//@RequestMapping("/templates/")
@Controller
public class showHtmlController{


    @GetMapping("test")
    public String re(){
        return "hellotest";
    }
//    @GetMapping("/templates")
//    String test(HttpServletRequest request) {
//        //逻辑处理
//        request.setAttribute("key", "hello world");
//        @PathVariable("page") String page
//        return "/index";
//    }

}
