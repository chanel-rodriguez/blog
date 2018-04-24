package com.codeup.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;


    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
