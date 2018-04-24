package com.codeup.blog.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "posts")
public class Post {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    @Size(min = 2,max = 30,message = "A title must be at least 3 characters.")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "Posts must have a description")
    private String body;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created_on;

    @ManyToMany(cascade = ALL)
    @JoinTable(
            name="posts_categories",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<Category> categories;

//    @Column(nullable = false)
//    private String type;


    public Post() {
    }

    public Post(long id, String title, String body, List<Category> cats ,Date created_on) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created_on = created_on;
        this.categories = cats;
//        this.type=type;
    }

    public Post(String title, String body, List<Category> cats) {
        this.title = title;
        this.body = body;
        this.categories = cats;
//        this.type = post_type;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public Date getCreated_on() { return created_on; }

    public void setCreated_on(Date created_on) { this.created_on = created_on; }

    public List<Category> getCategories() { return categories; }

    public void setCategories(List<Category> categories) { this.categories = categories; }

//    public String getType() { return type; }
//
//    public void setType(String type) { this.type = type; }
}
