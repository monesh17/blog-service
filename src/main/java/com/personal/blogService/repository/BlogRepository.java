package com.personal.blogService.repository;

import com.personal.blogService.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

  List<Blog> findByUserName(String userName);

  Blog findById(UUID id);

  List<Blog> findByIsSecured(boolean isSecured);

  List<Blog> findByIsSecuredFalse();
}
