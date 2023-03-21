package com.example.mvc_blogweb_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public String getAllBlogPosts(Model model) {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "blog-posts";
    }

    @GetMapping("/{id}")
    public String getBlogPostById(@PathVariable Long id, Model model) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        model.addAttribute("blogPost", blogPost);
        return "blog-post";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blogPost", new BlogPost());
        return "blog-post-form";
    }

    @PostMapping("/create")
    public String createBlogPost(@Validated @ModelAttribute("blogPost") BlogPost blogPost, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "blog-post-form";
        } else {
            blogPostService.createBlogPost(blogPost);
            return "redirect:/blog";
        }
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        model.addAttribute("blogPost", blogPost);
        return "blog-post-form";
    }

    @PostMapping("/{id}/edit")
    public String updateBlogPost(@PathVariable Long id, @Validated @ModelAttribute("blogPost") BlogPost updatedBlogPost, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "blog-post-form";
        } else {
            blogPostService.updateBlogPost(id, updatedBlogPost);
            return "redirect:/blog";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return "redirect:/blog";
    }
}
