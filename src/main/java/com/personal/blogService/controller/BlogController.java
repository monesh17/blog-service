package com.personal.blogService.controller;

import com.personal.blogService.controller.request.BlogListResponse;
import com.personal.blogService.controller.request.BlogPutRequest;
import com.personal.blogService.entity.Blog;
import com.personal.blogService.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {
  @Autowired BlogService blogService;

  @PostMapping(produces = "application/json; " + "charset=UTF-8")
  ResponseEntity<String> createBlog(@RequestBody Blog blogContent) {
    log.info(String.valueOf(blogContent));
    // TODO: need to find alternate
    blogContent.setUserName(blogContent.getUserName().trim().toLowerCase());
    blogService.saveBlog(blogContent);
    return ResponseEntity.ok("Blog Content Persisted");
  }

  @GetMapping(produces = "application/json; " + "charset=UTF-8")
  ResponseEntity<BlogListResponse> getBlogs(@RequestHeader String userName) {
    List<Blog> blogs = blogService.getBlogsForUser(userName);
    BlogListResponse response = new BlogListResponse();
    response.setBlogResponses(blogs);
    response.setCount(blogs.size());
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Blog> getBlogById(@PathVariable("id") UUID blogId) {
    Blog blog = blogService.getBlogById(blogId);
    return ResponseEntity.ok(blog);
  }

  @PutMapping(produces = "application/json; " + "charset=UTF-8")
  public ResponseEntity<Blog> updateBlogById(@RequestBody BlogPutRequest blogContent) {
    Blog blog = blogService.updateBlogById(blogContent);
    return ResponseEntity.ok(blog);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteBlogById(@PathVariable("id") UUID blogId) {
    boolean deleted = blogService.deleteBlogById(blogId);
    return ResponseEntity.ok(deleted);
  }
}
