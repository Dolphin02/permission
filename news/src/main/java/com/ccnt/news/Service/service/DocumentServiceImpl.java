package com.ccnt.news.Service.service;

import com.ccnt.news.Domain.Document;
import com.ccnt.news.Domain.NoticeResource;
import com.ccnt.news.Mapper.DocumentMapper;
import com.ccnt.news.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public Document getById(int id) {
        return documentMapper.selectFileById(id);
    }

    @Override
    public int add(Document document) {
        return documentMapper.add(document);
    }

    @Override
    public int update(Document document) {
        return 0;
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return documentMapper.deleteByIds(ids);
    }

    @Override
    public List<Document> getByType(String documentType) {
        return documentMapper.selectFileByType(documentType);
    }

    @Override
    public List<Document> getByDate() {
        return documentMapper.selectFileByDate();
    }

    @Override
    public List<Document> getAll() {
        return documentMapper.selectAllFile();
    }
}
