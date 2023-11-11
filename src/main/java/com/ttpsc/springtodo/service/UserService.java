package com.ttpsc.springtodo.service;

import com.ttpsc.springtodo.model.UserDTO;
import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;


    public List<UserEntity> getUsers (){
        return userRepository.findAll();
    }

    public UserEntity getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void addNewUser(UserDTO userDTO) {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());
        newUser.setRole("user");
        userRepository.save(newUser);
    }
}
