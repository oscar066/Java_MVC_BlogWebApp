package com.example.mvc_blogweb_app;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("BlogPost with id " + id + " not found"));
    }

    // Custom exception class
    public class CustomNotFoundException extends RuntimeException {
        public CustomNotFoundException(String message) {
            super(message);
        }
    }


    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost) {
        BlogPost blogPost = getBlogPostById(id);
        blogPost.setTitle(updatedBlogPost.getTitle());
        blogPost.setContent(updatedBlogPost.getContent());
        blogPost.setUpdatedAt(LocalDateTime.now());
        return blogPostRepository.save(blogPost);
    }

    public void deleteBlogPost(Long id) {
        BlogPost blogPost = getBlogPostById(id);
        blogPostRepository.delete(blogPost);
    }
}
