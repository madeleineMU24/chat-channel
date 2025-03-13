package com.example.chat_channel;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    UserService userService;


    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User result = userService.createUser(user);

        return ResponseEntity.ok(result);
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
       return userService.findUserById(id).orElseThrow(() -> new EntityNotFoundException("no user with id " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.findUserById(id).orElseThrow(() -> new EntityNotFoundException("no user with id " + id));
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User newUser){
        User user = userService.findUserById(id).orElseThrow(()-> new EntityNotFoundException("no user with id " + id));
        user.setName(newUser.getName());
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }

}
