package com.ccnt.news.Service.service;

import com.ccnt.news.Domain.NoticeResource;
import com.ccnt.news.Mapper.NoticeMapper;
import com.ccnt.news.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public NoticeResource getById(int id) {
        return noticeMapper.selectNewsById(id);
    }

    @Override
    public int add(NoticeResource noticeResource) {
        return noticeMapper.add(noticeResource);
    }

    @Override
    public int update(NoticeResource noticeResource) {
        return 0;
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return noticeMapper.deleteByIds(ids);
    }

    @Override
    public List<NoticeResource> getAll() {
        return noticeMapper.selectAllNews();
    }

    @Override
    public List<NoticeResource> getByDate() {
        return noticeMapper.selectNewsByDate();
    }

    @Override
    public List<NoticeResource> getByType(String newsType) {
        return noticeMapper.selectNewsByType(newsType);
    }

    @Override
    public String ShowHtml(String filepath) {
        String path = "Files/";
        String fileName = "选拔通知test.docx";
        String htmlName = "选拔通知.html";
//        if(fileName.endsWith("docx")){
//            try {
//                WordToHtml.Word2007ToHtml(path, fileName, htmlName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        else{
//            try {
//                WordToHtml.Word2003ToHtml(path, fileName, htmlName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (TransformerException e) {
//                e.printStackTrace();
//            } catch (ParserConfigurationException e) {
//                e.printStackTrace();
//            }
//        }

        return null;
    }
}
