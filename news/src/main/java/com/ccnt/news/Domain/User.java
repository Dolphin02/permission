package com.ccnt.news.Domain;

public class User {
    private Integer userId;
    private String username;
    private String password;
    private String level;
    private String submitTime;       //上传时间

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", level='" + level + '\'' +
                ", submit_time='" + submitTime + '\'' +
                '}';
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submit_time) {
        this.submitTime = submit_time;
    }

    public User(){

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
