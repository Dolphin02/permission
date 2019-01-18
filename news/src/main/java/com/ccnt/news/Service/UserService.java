package com.ccnt.news.Service;


import com.ccnt.news.Domain.User;

import java.util.List;

public interface UserService {
    User getById(int id);
    int add(User user);
    int updateUserLevel(int id);
    int updatepassword(int id, String newPwd);
    int deleteByIds(List<String> ids);
    List<User> getAll();
    List<User> getByDate();
    String ShowHtml(String filepath);
}
