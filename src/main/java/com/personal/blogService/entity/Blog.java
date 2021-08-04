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

    @Column(name = "userId", updatable = false, nullable = false)
    private int userId;


    @Column(name = "createdAt", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;

    @Type(type = "jsonb")
    @Column(name = "content",nullable = false,columnDefinition = "jsonb")
    private ObjectNode content;



}
