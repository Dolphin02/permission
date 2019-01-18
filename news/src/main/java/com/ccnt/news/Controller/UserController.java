package com.ccnt.news.Controller;

import com.ccnt.news.Domain.User;
import com.ccnt.news.Service.UserService;
import com.ccnt.news.tools.ServletUtil;
import com.ccnt.news.tools.StringUtil;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import javax.annotation.Notice;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户 id 查询----直接将结果返回给用户页面
     *
     * @param uid
     * @return
     */
    @ResponseBody
    @GetMapping("/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid) {
        System.out.println("------------findFilesById >>uid>" + uid);
        User noticeResource = userService.getById(uid);
        System.out.println("------------findFilesById >>user>" + noticeResource);
        return noticeResource;
    }


    /**
     * 查询最近的5个用户----直接将结果返回给用户页面
     *
     * @return
     */

    @RequestMapping("/latest_5")
    @ResponseBody
    public List<User> findUsersByDate() {
        System.out.println("------------findAllFiles >>>>>>");
        List<User> noticeList = userService.getByDate();
        System.out.println("------------findLatestNotices >>>>userList>>" + userService.getByDate().size());
        return noticeList;
    }

    /**
     * 查询所有用户----直接将结果返回给用户页面
     *
     * @return
     */

    @RequestMapping("")
    @ResponseBody
    public List<User> findAllUsers() {
        System.out.println("------------findAllUsers >>>>>>");
        List<User> userList = userService.getAll();
        System.out.println("------------findAllUsers >>>>userList>>" + userService.getAll().size());
        return userList;
    }

    @RequestMapping("/index")
    @ResponseBody
    public User index() {
        User userResource = userService.getById(1);
        return userResource;
    }

    /**
     * 新添
     * @param response
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addUser(@RequestBody Map<String, String> paras, HttpServletResponse response){
        JSONObject result=new JSONObject();
        String username = paras.get("username");
        String pwd = paras.get("password");
        String level = paras.get("level");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(new Date());

        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setLevel(level);
        user.setSubmitTime(time);
        System.out.println(user.toString());
        int index = userService.add(user);
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
     * 修改用户密码
     * @param request
     * @param response
     */
    @RequestMapping(value = "/update/pwd",method = RequestMethod.POST)
    public void updateUserPwd(@RequestBody Map<String, String> paras, HttpServletRequest request , HttpServletResponse response){
        com.alibaba.fastjson.JSONObject result=new com.alibaba.fastjson.JSONObject();
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getById(id);
        String username = paras.get("username");
        String pwd = paras.get("password");
        String level = paras.get("level");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(new Date());

        user.setUsername(username);
        user.setPassword(pwd);
        user.setLevel(level);
        user.setSubmitTime(time);
        int index = userService.updatepassword(id, pwd);
//        int index = learnService.update(document);
        System.out.println("修改结果="+index);
        if(index>0){
            result.put("message","用户信息修改成功!");
            result.put("flag",true);
        }else{
            result.put("message","用户信息修改失败!");
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
        int index = userService.deleteByIds(ids);
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
