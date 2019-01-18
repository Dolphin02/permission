package com.ccnt.news.Controller;

import com.ccnt.news.Domain.Document;
import com.ccnt.news.Service.DocumentService;
import com.ccnt.news.tools.StringUtil;
import com.ccnt.news.tools.ServletUtil;
import fr.opensagres.xdocreport.document.json.JSONObject;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/files")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    /**
     * 根据文件 id 查询----直接将结果返回给用户页面
     *
     * @param documentId
     * @return
     */
    @ResponseBody
    @GetMapping("/{documentId}")
    public Document findFilesById(@PathVariable("documentId") Integer documentId) {
        System.out.println("------------findFileById >>uid>" + documentId);
        Document document = documentService.getById(documentId);
        System.out.println("------------findFileById >>document>" + document);
        return document;
    }

    /**
     * 根据文件 document_type 查询----直接将结果返回给用户页面
     *
     * @param documentType
     * @return
     */
    @ResponseBody
    @GetMapping("/type/{documentType}")
    public List<Document> findFilesByType(@PathVariable("documentType") String documentType) {
        System.out.println("------------findFileByType >>Type>" + documentType);
        List<Document> document = documentService.getByType(documentType);
        System.out.println("------------findFileByType >>document>" + document);
        return document;
    }

    /**
     * 查询最近的5条文件----直接将结果返回给用户页面
     *
     * @return
     */

    @RequestMapping("/latest_5")
    @ResponseBody
    public List<Document> findFilesByDate() {
        System.out.println("------------findAllFiles >>>>>>");
        List<Document> documentList = documentService.getByDate();
        System.out.println("------------findAllFiles >>>>userList>>" + documentService.getByDate().size());
        return documentList;
    }

    /**
     * 查询所有文件----直接将结果返回给用户页面
     *
     * @return
     */

    @RequestMapping(value = "", produces="application/json;charset=utf-8")
    @ResponseBody
    public List<Document> findAllFiles() {
        System.out.println("------------findAllFiles >>>>>>");
        List<Document> documentList = documentService.getAll();
        System.out.println("------------findAllFiles >>>>userList>>" + documentService.getAll().size());
        return documentList;
    }

    /**
     * 新添
     * @param response
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addLearn(@RequestBody Map<String, String> paras, HttpServletResponse response){
        JSONObject result=new JSONObject();
        String author = paras.get("document_author");
        String name = paras.get("document_name");
        String title = paras.get("document_title");
        String url = paras.get("document_url");
        String topic = paras.get("document_type");
        String remark = paras.get("document_remark");
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

        Document document = new Document();
        document.setDocumentAuthor(author);
        document.setDocumentTitle(title);
        document.setDocumentName(name);
        document.setDocumentUrl(url);
        document.setDocumentType(topic);
        document.setDocumentRemark(remark);
        document.setSubmitTime(time);
        System.out.println(document.toString());
//        document.setFileType(filetype);
        int index = documentService.add(document);
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
        int index = documentService.deleteByIds(ids);
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
