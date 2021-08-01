package com.personal.blogService.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class Blog {
    @PostMapping(produces = "application/json; " + "charset=UTF-8")
    ResponseEntity<String> registerSLADefinition(
            @RequestBody String blogContent,
            @RequestHeader String username) {
        log.info(blogContent);
        return ResponseEntity.ok("Blog Content Recieved");
    }
}
