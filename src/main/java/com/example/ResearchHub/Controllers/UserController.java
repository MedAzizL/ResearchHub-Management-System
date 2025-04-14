package com.example.ResearchHub.Controllers;

import com.example.ResearchHub.Dto.UserCreateRequest;
import com.example.ResearchHub.Dto.UserUpdateRequest;
import com.example.ResearchHub.Entities.User;
import com.example.ResearchHub.Services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        userService.createUser(userCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @GetMapping
    public  List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserUpdateRequest userUpdateRequest, @PathVariable int id) {
        userService.updateUser(userUpdateRequest, id);
        return ResponseEntity.ok("User updated successfully");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " not found"));
    }


    @GetMapping("/search/username")
    public ResponseEntity<List<User>> searchUsersByname(@RequestParam String keyword) {
        List<User> users = userService.searchUsersByName(keyword);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/search/email/{email}")
    public User searchUserByEmail(@PathVariable String email) {
        return userService.searchUserByEmail(email);
    }
}
