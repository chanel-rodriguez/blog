package com.codeup.blog.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created_on;

//    @Column(nullable = false)
//    private Category category;

    @Column(nullable = false)
    private String type;


    public Post() {
    }

    public Post(long id, String title, String body, String type ,Date created_on) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created_on = created_on;
//        this.category = type;
        this.type=type;
    }

    public Post(String title, String body, String post_type) {
        this.title = title;
        this.body = body;
//        this.category = post_type;
        this.type = post_type;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public Date getCreated_on() { return created_on; }

    public void setCreated_on(Date created_on) { this.created_on = created_on; }

//    public Category getCategory() { return category; }
//
//    public void setCategory(Category category) { this.category = category; }


    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
