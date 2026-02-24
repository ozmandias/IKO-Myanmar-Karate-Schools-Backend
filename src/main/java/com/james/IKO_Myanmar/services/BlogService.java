package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.models.Blog;
import com.james.IKO_Myanmar.repositories.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepositoryDependency) {
        this.blogRepository = blogRepositoryDependency;
    }

    public Blog createBlog(Blog blogData) {
        blogData.createDate = LocalDateTime.now();
        return blogRepository.save(blogData);
    }

    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlog(Long id) {
        return blogRepository.findById(id);
    }

    public Blog updateBlog(Long id, Blog blogData) {
        Optional<Blog> optionalBlog = getBlog(id);
        Blog blog = null;
        if(optionalBlog.isPresent()) {
            blog = optionalBlog.get();
            blogData.id = blog.id;
            blogData.createDate = blog.createDate;
            blogData.updateDate = LocalDateTime.now();
            blog = blogRepository.save(blogData);
        }
        return blog;
    }

    public boolean deleteBlog(Long id) {
        boolean deleteStatus = false;
        Optional<Blog> optionalBlog = getBlog(id);
        Blog blog = null;
        if(optionalBlog.isPresent()) {
            blog = optionalBlog.get();
            blogRepository.delete(blog);
            deleteStatus = true;
        }
        return deleteStatus;
    }
}