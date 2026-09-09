package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.models.Blog;
import com.james.IKO_Myanmar.repositories.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepositoryDependency) {
        this.blogRepository = blogRepositoryDependency;
    }

    public Blog createBlog(Blog blogData) {
        blogData.setCreateDate(LocalDateTime.now());
        return blogRepository.save(blogData);
    }

    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    public List<Blog> getBlogsPagination() {
        return null;
    }

    public Blog getBlog(Long id) {
        return blogRepository.findById(id).orElseThrow();
    }

    public Blog updateBlog(Long id, Blog blogData) {
        Blog blog = getBlog(id);
        blogData.setId(blog.getId());
        blogData.setCreateDate(blog.getCreateDate());
        blogData.setUpdateDate(LocalDateTime.now());
        blog = blogRepository.save(blogData);
        return blog;
    }

    public void deleteBlog(Long id) {
        Blog blog = getBlog(id);
        blogRepository.delete(blog);
    }
}