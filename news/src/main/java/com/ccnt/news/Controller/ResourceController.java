package com.ccnt.news.Controller;

import com.ccnt.news.Domain.Resources;
import com.ccnt.news.Service.ResourceService;
import com.ccnt.news.tools.ServletUtil;
import com.ccnt.news.tools.StringUtil;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 根据文件 id 查询----直接将结果返回给用户页面
     *
     * @param resourceId
     * @return
     */
    @ResponseBody
    @GetMapping("/{resourceId}")
    public Resources findresourcesById(@PathVariable("resourceId") Integer resourceId) {
        System.out.println("------------findResourceById >>uid>" + resourceId);
        Resources resource = resourceService.getById(resourceId);
        System.out.println("------------findResourceById >>resource>" + resource);
        return resource;
    }

    /**
     * 根据文件 resource_type 查询----直接将结果返回给用户页面
     *
     * @param resourceType
     * @return
     */
    @ResponseBody
    @GetMapping("/type/{resourceType}")
    public List<Resources> findResourcesByType(@PathVariable("resourceType") String resourceType) {
        System.out.println("------------findResourceByType >>Type>" + resourceType);
        List<Resources> resource = resourceService.getByType(resourceType);
        System.out.println("------------findResourceByType >>resource>" + resource);
        return resource;
    }

    /**
     * 查询最近的5条文件----直接将结果返回给用户页面
     *
     * @return
     */

    @RequestMapping("/latest_5")
    @ResponseBody
    public List<Resources> findResourcesByDate() {
        System.out.println("------------findAllResources >>>>>>");
        List<Resources> resourceList = resourceService.getByDate();
        System.out.println("------------findAllResources >>>>userList>>" + resourceService.getByDate().size());
        return resourceList;
    }

    /**
     * 查询所有文件----直接将结果返回给用户页面
     *
     * @return
     */

    @RequestMapping(value = "", produces="application/json;charset=utf-8")
    @ResponseBody
    public List<Resources> findAllResources() {
        System.out.println("------------findAllResources >>>>>>");
        List<Resources> resourceList = resourceService.getAll();
        System.out.println("------------findAllResources >>>>userList>>" + resourceService.getAll().size());
        return resourceList;
    }

    /**
     * 新添
     * @param response
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addLearn(@RequestBody Map<String, String> paras, HttpServletResponse response){
        JSONObject result=new JSONObject();
        String author = paras.get("resource_author");
//        String name = paras.get("resource_name");
        String title = paras.get("resource_title");
        String url = paras.get("resource_url");
        String topic = paras.get("resource_type");
        String remark = paras.get("resource_remark");
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

        Resources resource = new Resources();
        resource.setResourceAuthor(author);
        resource.setResourceTitle(title);
//        resource.setResourceName(name);
        resource.setResourceUrl(url);
        resource.setResourceType(topic);
        resource.setResourceRemark(remark);
        resource.setSubmitTime(time);
        System.out.println(resource.toString());
//        resource.setFileType(filetype);
        int index = resourceService.add(resource);
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
        int index = resourceService.deleteByIds(ids);
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
