package com.example.ResearchHub.Services;

import com.example.ResearchHub.Dto.UserCreateRequest;
import com.example.ResearchHub.Dto.UserUpdateRequest;
import com.example.ResearchHub.Entities.User;
import com.example.ResearchHub.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public ResponseEntity<String> createUser(UserCreateRequest userCreateRequest) {
        if (userRepository.findByEmail(userCreateRequest.getEmail()).isPresent()){
            return new ResponseEntity<>("email is taken",HttpStatus.BAD_REQUEST);
        }

        User user = User.builder()
                .firstName(userCreateRequest.getFirstName())
                .lastName(userCreateRequest.getLastName())
                .email(userCreateRequest.getEmail())
                .grade(userCreateRequest.getGrade())
                .role(userCreateRequest.getRole())
                .employmentDate(userCreateRequest.getEmploymentDate())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()))
                .lastDiploma(userCreateRequest.getLastDiploma())
                .originalEstablishment(userCreateRequest.getOriginalEstablishment())
                .build();

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUser(UserUpdateRequest userUpdateRequest, int id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(userUpdateRequest.getFirstName());
        user.setLastName(userUpdateRequest.getLastName());
        user.setEmail(userUpdateRequest.getEmail());
        user.setEmploymentDate(userUpdateRequest.getEmploymentDate());
        user.setPassword(userUpdateRequest.getPassword());
        user.setLastDiploma(userUpdateRequest.getLastDiploma());
        user.setOriginalEstablishment(userUpdateRequest.getOriginalEstablishment());
        user.setGrade(userUpdateRequest.getGrade());


        userRepository.save(user);
    }
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }
    public Optional<User> getUserByemail(String email) {
        return userRepository.findByEmail(email);
    }
}
