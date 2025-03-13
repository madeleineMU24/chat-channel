package com.example.chat_channel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepo;

    UserRepository userRepo;

    ChannelRepository channelRepo;

    public PostService(PostRepository postRepo, UserRepository userRepo, ChannelRepository channelRepo){
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.channelRepo = channelRepo;
    }

    public boolean userExists(Long userId){
        return userRepo.existsById(userId);
    }
    public boolean channelExists(Long channelId){
        return userRepo.existsById(channelId);
    }

    public Post createPost(Post post){
        if(userExists(post.getUser().getId()) && channelExists(post.getChannel().getId())){
            return postRepo.save(post);
        }else{
            throw new IllegalArgumentException("User or channel does not exist");
        }

    }

    public List<Post> findAllPosts(){
        return postRepo.findAll();
    }

    public Optional<Post> findPostById(Long id){
        return postRepo.findById(id);
    }

    public void deletePostById(Long id){
        postRepo.deleteById(id);
    }


}
