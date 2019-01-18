package com.ccnt.news.Service.service;

import com.ccnt.news.Domain.User;
import com.ccnt.news.Mapper.UserMapper;
import com.ccnt.news.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int updateUserLevel(int id) {
        return userMapper.updateUserLevel(id);
    }

    @Override
    public int updatepassword(int id, String newPwd) {
        return userMapper.updatePassword(id, newPwd);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return userMapper.deleteByIds(ids);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectAllUsers();
    }

    @Override
    public List<User> getByDate() {
        return userMapper.selectUserByDate();
    }

//    @Override
//    public List<User> getByType(String newsType) {
//        return userMapper.selectUserByType(newsType);
//    }

    @Override
    public String ShowHtml(String filepath) {
        String path = "Files/";
        String fileName = "选拔通知test.docx";
        String htmlName = "选拔通知.html";

        return null;
    }
}
