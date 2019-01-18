package com.ccnt.news.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeResource {
    private Integer newsId;
    private String newsAuthor;
    private String newsTitle;
    private String newsUrl;
    private String newsType;
    private String submitTime;

    @Override
    public String toString() {
        return "NoticeResource{" +
                "newsId=" + newsId +
                ", newsAuthor='" + newsAuthor + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsUrl='" + newsUrl + '\'' +
                ", newsType='" + newsType + '\'' +
                ", submitTime=" + submitTime +
                '}';
    }

    public NoticeResource() {
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {


        this.submitTime = submitTime;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }


}