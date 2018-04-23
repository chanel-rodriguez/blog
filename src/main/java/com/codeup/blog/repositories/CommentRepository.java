package com.codeup.blog.repositories;

import com.codeup.blog.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository <Comment,Long> {

}
