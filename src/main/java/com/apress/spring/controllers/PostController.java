package com.apress.spring.controllers;

import com.apress.spring.domain.Comment;
import com.apress.spring.domain.Post;
import com.apress.spring.repository.CommentRepository;
import com.apress.spring.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;


    @ResponseBody
    @GetMapping("")
    public List<Post> listPosts()
    {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable("id") Integer id)
    {

        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No post found with id="+id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Post createPost(@RequestBody Post post){

        return postRepository.save(post);

    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable("id") Integer id, @RequestBody Post post){
        postRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found " + id));
        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Integer id){
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Post not found: " + id));
        postRepository.deleteById(post.getId());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/comments")
    public void createPostComment(@PathVariable("id") Integer id,
                                  @RequestBody Comment comment)
    {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("No post found with id="+id));
        post.getComments().add(comment);
    }
}
