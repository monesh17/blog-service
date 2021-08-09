package com.personal.blogService.controller.request;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogPutRequest implements Serializable {
  private UUID id;
  private List<String> tags;
  private ObjectNode content;
}
