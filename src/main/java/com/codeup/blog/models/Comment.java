package com.codeup.blog.models;

import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private User user;

    @Column(nullable = false , columnDefinition = "TEXT")
    private String body;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created_on;

    public Comment() {
    }

    public Comment(User user, String body) {
        this.user = user;
        this.body = body;
    }

    public Comment(long id, User user, String body, Date created_on) {
        this.id = id;
        this.user = user;
        this.body = body;
        this.created_on = created_on;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }
}
