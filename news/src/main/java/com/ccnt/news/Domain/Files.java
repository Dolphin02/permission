package com.ccnt.news.Domain;

public class Files {
    private Integer fileId;      //资料ID
    private String fileAuthor;   //上传人
    private String fileRemark;   //资料描述
    private String fileTitle;    //资料标题
    private String fileUrl;      //资料地址
    private String submitTime;   //上传时间
    private String fileType;     //文件类型 word pdf zip
//    private MultipartFile multipartFile;


    public String getFileType() {
        return fileType;
    }

    public Integer getFileId() {
        return fileId;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileRemark() {
        return fileRemark;
    }

    public void setFileRemark(String fileRemark) {
        this.fileRemark = fileRemark;
    }

    public String getFileAuthor() {
        return fileAuthor;
    }

    public void setFileAuthor(String fileAuthor) {
        this.fileAuthor = fileAuthor;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }



}
