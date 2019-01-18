package com.ccnt.news.Controller;

import com.ccnt.news.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class NoticeDetailController {

    @Autowired
    private NoticeService noticeService;

    @ResponseBody
    @RequestMapping(value = "/notice_content", method = RequestMethod.POST)
    public String showNotice(@RequestParam String filename){
        System.out.println(filename);
        String redictPrex = "redirect:/news_detail";
        return redictPrex;

//        noticeService.ShowHtml("Files");
    }

}
