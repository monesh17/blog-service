package com.personal.blogService.controller;


import com.personal.blogService.controller.request.BlogPostRequest;
import com.personal.blogService.entity.Blog;
import com.personal.blogService.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping(produces = "application/json; " + "charset=UTF-8")
    ResponseEntity<String> createBlog(
            @RequestBody Blog blogContent,
            @RequestHeader String username) {
        log.info(String.valueOf(blogContent));
        blogService.saveBlog(blogContent);
        return ResponseEntity.ok("Blog Content Persisted");
    }
}
