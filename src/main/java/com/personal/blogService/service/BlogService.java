package com.personal.blogService.service;

import com.personal.blogService.controller.request.BlogPutRequest;
import com.personal.blogService.entity.Blog;
import com.personal.blogService.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class BlogService {
  @Autowired private BlogRepository blogRepository;

  public boolean saveBlog(Blog blog) {
    if (Objects.nonNull(blog)) {
      blogRepository.save(blog);
      return true;
    } else {
      return false;
    }
  }

  public List<Blog> getBlogsForUser(String userName) {
    List<Blog> blogs = blogRepository.findByUserName(userName);
    return blogs;
  }

  public Blog getBlogById(UUID id) {
    Blog blog = blogRepository.findById(id);
    return blog;
  }

  public Blog updateBlogById(BlogPutRequest updateBlog) {
    Blog blog = blogRepository.findById(updateBlog.getId());
    blog.setTags(updateBlog.getTags());
    blog.setContent(updateBlog.getContent());
    blog.setUpdatedAt(LocalDateTime.now());
    return blogRepository.save(blog);
  }

  public boolean deleteBlogById(UUID id) {
    Blog blog = blogRepository.findById(id);
    blogRepository.delete(blog);
    return true;
  }

  public List<Blog> getSecuredBlogsForUser(String userName) {
    // TODO: for now not considering the username
    List<Blog> blogs = blogRepository.findByIsSecured(true);
    return blogs;
  }
}
