package com.ccnt.news.Service;

import com.ccnt.news.Domain.Document;

import java.util.List;

public interface DocumentService {
    Document getById(int id);
    int add(Document document);
    int update(Document document);
    int deleteByIds(List<String> ids);
    List<Document> getByType(String documentType);
    List<Document> getByDate ();
    List<Document> getAll();
}
