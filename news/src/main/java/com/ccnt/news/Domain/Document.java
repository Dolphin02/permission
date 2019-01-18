package com.ccnt.news.Domain;

import org.springframework.web.multipart.MultipartFile;

public class Document {
    private Integer documentId;      //资料ID
    private String documentAuthor;   //上传人
    private String documentRemark;   //资料描述
    private String documentTitle;    //资料标题
    private String documentName;    //资料文件名
    private String documentUrl;      //资料地址
    private String submitTime;       //上传时间
    private String documentType;     //资料类型
    private String fileType;         //文件类型 word pdf zip
    private MultipartFile multipartFile;

    public Document() {
    }

    public String getFileType() {
        return fileType;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public String getDocumentAuthor() {
        return documentAuthor;
    }

    public void setDocumentAuthor(String documentAuthor) {
        this.documentAuthor = documentAuthor;
    }


    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getDocumentRemark() {
        return documentRemark;
    }

    public void setDocumentRemark(String documentRemark) {
        this.documentRemark = documentRemark;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", documentAuthor='" + documentAuthor + '\'' +
                ", documentRemark='" + documentRemark + '\'' +
                ", documentTitle='" + documentTitle + '\'' +
                ", documentName='" + documentName + '\'' +
                ", documentUrl='" + documentUrl + '\'' +
                ", submitTime='" + submitTime + '\'' +
                ", documentType='" + documentType + '\'' +
                ", fileType='" + fileType + '\'' +
                ", multipartFile=" + multipartFile +
                '}';
    }
}
