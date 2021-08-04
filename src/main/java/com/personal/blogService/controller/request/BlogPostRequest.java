package com.personal.blogService.controller.request;

import com.personal.blogService.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogPostRequest {
    private Blog blog;
}
