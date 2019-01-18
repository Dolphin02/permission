package com.ccnt.news.Controller;

import com.ccnt.news.Domain.NoticeResource;
import com.ccnt.news.Mapper.NoticeMapper;
import com.ccnt.news.Service.NoticeService;
import com.ccnt.news.tools.ServletUtil;
import com.ccnt.news.tools.StringUtil;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import javax.annotation.Notice;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

//    @Autowired
//    private NoticeMapper noticeMapper;


    /**
     * 根据用户 id 查询----直接将结果返回给用户页面
     *
     * @param uid
     * @return
     */
    @ResponseBody
    @GetMapping("/{uid}")
    public NoticeResource findNoticesById(@PathVariable("uid") Integer uid) {
        System.out.println("------------findFilesById >>uid>" + uid);
        NoticeResource noticeResource = noticeService.getById(uid);
        System.out.println("------------findFilesById >>user>" + noticeResource);
        return noticeResource;
    }

    /**
     * 根据用户 notice_type 查询----直接将结果返回给用户页面
     *
     * @param notice_type
     * @return
     */
    @ResponseBody
    @GetMapping("/type/{notice_type}")
    public List<NoticeResource> findNoticesByType(@PathVariable("notice_type") String notice_type) {
        System.out.println("------------findFilesById >>uid>" + notice_type);
        List<NoticeResource> noticeResource = noticeService.getByType(notice_type);
        System.out.println("------------findFilesById >>user>" + noticeResource);
        return noticeResource;
    }

    /**
     * 查询最近的5条文件----直接将结果返回给用户页面
     *
     * @return
     */

    @RequestMapping("/latest_5")
    @ResponseBody
    public List<NoticeResource> findNoticesByDate() {
        System.out.println("------------findAllFiles >>>>>>");
        List<NoticeResource> noticeList = noticeService.getByDate();
        System.out.println("------------findLatestNotices >>>>userList>>" + noticeService.getByDate().size());
        return noticeList;
    }

    /**
     * 查询所有用户----直接将结果返回给用户页面
     *
     * @return
     */

    @RequestMapping("")
    @ResponseBody
    public List<NoticeResource> findAllNotices() {
        System.out.println("------------findAllNotices >>>>>>");
        List<NoticeResource> noticeList = noticeService.getAll();
        System.out.println("------------findAllNotices >>>>userList>>" + noticeService.getAll().size());
        return noticeList;
    }

    @RequestMapping("/index")
    @ResponseBody
    public NoticeResource index() {
        NoticeResource noticeResource = noticeService.getById(1);
        return noticeResource;
    }

    /**
     * 新添
     * @param response
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addLearn(@RequestBody Map<String, String> paras, HttpServletResponse response){
        JSONObject result=new JSONObject();
        String author = paras.get("news_author");
        String title = paras.get("news_title");
        String url = paras.get("news_url");
        String topic = paras.get("news_type");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(new Date());

        if(StringUtil.isNull(author)){
            result.put("message","作者不能为空!");
            result.put("flag",false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if(StringUtil.isNull(title)){
            result.put("message","标题不能为空!");
            result.put("flag",false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
//        if(StringUtil.isNull(url)){
//            result.put("message","地址不能为空!");
//            result.put("flag",false);
//            ServletUtil.createSuccessResponse(200, result, response);
//            return;
//        }

        NoticeResource noticeresource = new NoticeResource();
        noticeresource.setNewsAuthor(author);
        noticeresource.setNewsTitle(title);
//        resource.setResourceName(name);
        noticeresource.setNewsUrl(url);
        noticeresource.setNewsType(topic);
        noticeresource.setSubmitTime(time);
        System.out.println(noticeresource.toString());
//        resource.setFileType(filetype);
        int index = noticeService.add(noticeresource);
        System.out.println("结果="+index);
        if(index>0){
            result.put("message","发布成功!");
            result.put("flag",true);
        }else{
            result.put("message","发布失败!");
            result.put("flag",false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 删除
     * @param response
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void deleteByIds(@RequestBody Map<String, List<String>> paras, HttpServletResponse response){
        List<String> ids = paras.get("ids");
        System.out.println("=======================================================");
        System.out.println("ids==="+ids);
        System.out.println("=======================================================");
        com.alibaba.fastjson.JSONObject result = new com.alibaba.fastjson.JSONObject();
        //删除操作
        int index = noticeService.deleteByIds(ids);
        if(index>0){
            result.put("message","信息删除成功!");
            result.put("flag",true);
        }else{
            result.put("message","信息删除失败!");
            result.put("flag",false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }
}
