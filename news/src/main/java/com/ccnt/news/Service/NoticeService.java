package com.ccnt.news.Service;

import com.ccnt.news.Domain.NoticeResource;

import java.util.List;

public interface NoticeService {
    NoticeResource getById(int id);
    int add(NoticeResource noticeResource);
    int update(NoticeResource noticeResource);
    int deleteByIds(List<String> ids);
    List<NoticeResource> getAll();
    List<NoticeResource> getByDate();
    List<NoticeResource> getByType(String newsType);
    String ShowHtml(String filepath);
}
