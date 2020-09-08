package com.yurylink.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileDto {

    private String fileName;
    private String title;
    private String subtitle;
    private String header;
    private List<String> body;
    private String trailer;

    public FileDto() {
        this.fileName = "";
        this.title = "";
        this.subtitle = "";
        this.header = "";
        this.body = new ArrayList<>();
        this.trailer = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(final String subtitle) {
        this.subtitle = subtitle;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(final String header) {
        this.header = header;
    }

    public List<String> getBody() {
        return body;
    }

    public void setBody(final List<String> body) {
        this.body = body;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(final String trailer) {
        this.trailer = trailer;
    }
}
