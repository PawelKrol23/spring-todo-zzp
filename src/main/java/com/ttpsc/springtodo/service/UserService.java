package com.ttpsc.springtodo.service;

import com.ttpsc.springtodo.model.User;
import com.ttpsc.springtodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;


    public List<User> getUsers (){
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
