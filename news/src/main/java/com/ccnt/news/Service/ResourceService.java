package com.ccnt.news.Service;


import com.ccnt.news.Domain.Resources;

import java.util.List;
import java.util.Map;

public interface ResourceService {
    int add(Resources resources);
    int update(Resources resources);
    int deleteByIds(List<String> ids);
    Resources getById(int id);
    List<Resources> getByType(String resourceType);
    List<Resources> getByDate ();
    List<Resources> getAll();
}
