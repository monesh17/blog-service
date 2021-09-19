package com.personal.blogService.entity;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@TypeDefs({
  @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
})
@Entity
@Data
public class Blog {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "name", updatable = false, nullable = false)
  private String name;

  @Type(type = "jsonb")
  @Column(name = "tags", columnDefinition = "jsonb")
  private List<String> tags;

  @Column(name = "user_name", updatable = false, nullable = false)
  private String userName;

  @Column(name = "created_at", updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_At")
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;

  @Type(type = "jsonb")
  @Column(name = "content", nullable = false, columnDefinition = "jsonb")
  private ObjectNode content;

  @Column(name = "is_secured")
  private Boolean isSecured;
}
