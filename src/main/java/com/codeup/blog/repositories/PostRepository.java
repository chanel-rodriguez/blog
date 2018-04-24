package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository <Post, Long> {

}
