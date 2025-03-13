package com.example.chat_channel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepo;

    public PostService(PostRepository postRepo){
        this.postRepo = postRepo;
    }

    public Post createPost(Post post){
        return postRepo.save(post);
    }

    public List<Post> findAllPosts(){
        return postRepo.findAll();
    }

    public Optional<Post> findPostById(Long id){
        return postRepo.findById(id);
    }


}
