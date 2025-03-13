package com.example.chat_channel;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<User> user = userService.findUserById(id);
        return user.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@Valid @RequestBody User newUser){
        User user = userService.updateUser(newUser);
        if (user != null){
            return ResponseEntity.accepted().body(newUser);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
