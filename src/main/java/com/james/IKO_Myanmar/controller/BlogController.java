package com.james.IKO_Myanmar.controller;

import com.james.IKO_Myanmar.model.Blog;
import com.james.IKO_Myanmar.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogServiceDependency) {
        this.blogService = blogServiceDependency;
    }

    @GetMapping("/blogs")
    public ResponseEntity getBlogs() {
        List<Blog> blogs = blogService.getBlogs();

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(blogs != null ? blogs : Collections.emptyList());

        return response;
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity getBlog(@PathVariable("id") Long id) {
        Optional<Blog> optionalBlog = blogService.getBlog(id);
        Blog blog = null;
        if(optionalBlog.isPresent()) {
            blog = optionalBlog.get();
        }

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(blog != null ? blog : Collections.emptyMap());

        return response;
    }

    @PostMapping("/blogs")
    public ResponseEntity postBlog(@RequestBody Blog blogData) {
        Blog blog = blogService.createBlog(blogData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(blog != null ? blog : Collections.emptyMap());

        return response;
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity putBlog(@PathVariable("id") Long id, @RequestBody Blog blogData) {
        Blog blog = blogService.updateBlog(id, blogData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(blog != null ? blog : Collections.emptyMap());

        return response;
    }

    @DeleteMapping("/blogs/{id}")
    public ResponseEntity deleteBlog(@PathVariable("id") Long id) {
        boolean deleteSuccess = blogService.deleteBlog(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess == true ? "delete successful!" : "delete failed!");

        return response;
    }
}
