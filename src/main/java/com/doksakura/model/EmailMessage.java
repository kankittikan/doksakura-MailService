package com.doksakura.model;

import com.google.gson.Gson;

public class EmailMessage {

    private String personal;
    private String to;
    private String header;
    private String html;

    public EmailMessage(String personal, String to, String header, String html) {
        this.personal = personal;
        this.to = to;
        this.header = header;
        this.html = html;
    }

    public String getPersonal() {
        return personal;
    }

    public String getTo() {
        return to;
    }

    public String getHeader() {
        return header;
    }

    public String getHtml() {
        return html;
    }
}