package com.ccnt.news.Domain;

public class Resources {
    private Integer resourceId;      //资料ID
    private String resourceAuthor;   //上传人
    private String resourceRemark;   //资料描述
    private String resourceTitle;    //资料标题
    private String resourceUrl;      //资料地址
    private String submitTime;   //上传时间
    private String resourceType;     //文件类型 word pdf zip
//    private Multipartresource multipartresource;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceAuthor() {
        return resourceAuthor;
    }

    public void setResourceAuthor(String resourceAuthor) {
        this.resourceAuthor = resourceAuthor;
    }

    public String getResourceRemark() {
        return resourceRemark;
    }

    public void setResourceRemark(String resourceRemark) {
        this.resourceRemark = resourceRemark;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Resources() {
    }

    @Override
    public String toString() {
        return "Resources{" +
                "resourceId=" + resourceId +
                ", resourceAuthor='" + resourceAuthor + '\'' +
                ", resourceRemark='" + resourceRemark + '\'' +
                ", resourceTitle='" + resourceTitle + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", submitTime='" + submitTime + '\'' +
                ", resourceType='" + resourceType + '\'' +
                '}';
    }
}
