package com.example.ResearchHub.Services;

import com.example.ResearchHub.Dto.UserCreateRequest;
import com.example.ResearchHub.Entities.User;
import com.example.ResearchHub.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserCreateRequest userCreateRequest) {
        User user = User.builder()
                .firstName(userCreateRequest.getFirstName())
                .lastName(userCreateRequest.getLastName())
                .email(userCreateRequest.getEmail())
                .grade(userCreateRequest.getGrade())
                .role(userCreateRequest.getRole())
                .employmentDate(userCreateRequest.getEmploymentDate())
                .password(userCreateRequest.getPassword())
                .lastDiploma(userCreateRequest.getLastDiploma())
                .originalEstablishment(userCreateRequest.getOriginalEstablishment())
                .build();

        userRepository.save(user);
    }

    


}
