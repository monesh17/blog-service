package com.personal.blogService.controller.request;

import com.personal.blogService.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogListResponse implements Serializable {
  private List<Blog> blogResponses;
  private int count;
  private String message;
}

