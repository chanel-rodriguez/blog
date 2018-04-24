package com.codeup.blog.repositories;

import com.codeup.blog.models.Category;
import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository <Category, Long> {
    @Query(value = "select DISTINCT name from categories", nativeQuery = true)
    List<String> findByUnique();
}
