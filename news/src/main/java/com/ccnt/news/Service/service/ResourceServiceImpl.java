package com.ccnt.news.Service.service;

import com.ccnt.news.Domain.Resources;
import com.ccnt.news.Mapper.ResourceMapper;
import com.ccnt.news.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public int add(Resources resources) {
        return resourceMapper.add(resources);
    }

    @Override
    public int update(Resources resources) {
        return 0;
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return resourceMapper.deleteByIds(ids);
    }

    @Override
    public Resources getById(int id) {
        return resourceMapper.selectResourceById(id);
    }

    @Override
    public List<Resources> getByType(String resourceType) {
        return resourceMapper.selectResourceByType(resourceType);
    }

    @Override
    public List<Resources> getByDate() {
        return resourceMapper.selectResourceByDate();
    }

    @Override
    public List<Resources> getAll() {
        return resourceMapper.selectAllResources();
    }
}
