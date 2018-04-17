package com.codeup.blog.models;

import java.util.Date;

public class Post {
    private long id;
    private String title;
    private String body;
    private Date created_on;

    public Post(long id, String title, String body, Date created_on) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created_on = created_on;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public Date getCreated_on() { return created_on; }

    public void setCreated_on(Date created_on) { this.created_on = created_on; }
}