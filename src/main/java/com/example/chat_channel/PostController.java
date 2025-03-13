package com.example.chat_channel;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        Post result = postService.createPost(post);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id){
        postService.findPostById(id).orElseThrow(() -> new EntityNotFoundException("no post with id " + id));
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Post findPostById(@PathVariable Long id){
        return postService.findPostById(id).orElseThrow(()-> new EntityNotFoundException("no post with id " + id));
    }

}