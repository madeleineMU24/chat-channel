package com.example.chat_channel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> findUserById(Long id){
        return userRepo.findById(id);
    }

    public void deleteUserById(Long id){
        userRepo.deleteById(id);
    }

}
