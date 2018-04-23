package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository <Post, Long> {

    @Query(value = "select * from posts where type = ?1", nativeQuery = true)
    List<Post> findByType(String type);
}
