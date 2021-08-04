package com.personal.blogService.service;

import com.personal.blogService.entity.Blog;
import com.personal.blogService.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

  public boolean saveBlog(Blog blog) {
    if (Objects.nonNull(blog)) {
      blogRepository.save(blog);
      return true;
    } else {
      return false;
    }
    }
}
