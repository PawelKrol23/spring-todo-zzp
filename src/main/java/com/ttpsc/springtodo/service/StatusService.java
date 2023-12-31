package com.ttpsc.springtodo.service;

import com.ttpsc.springtodo.model.Status;
import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.repository.StatusRepository;
import com.ttpsc.springtodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StatusService {
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;


    public List<Status> getStatuses(Long userId){
        return statusRepository.getUsersStatuses(userId);
    }

    public Status getStatus(Long id) {
        return statusRepository.findById(id).orElseThrow();
    }

    public Status getStatusByName(String name, Long userId) {
        return statusRepository.getStatusByName(name, userId);
    }

    public void addStatusForUser(Status status, String username) {
        status.setId(null);

        UserEntity user = userRepository.findByUsername(username).orElseThrow();
        status.setOwner(user);

        statusRepository.save(status);
    }

    public void updateStatus(Long id, Status status) {
        Status statusFromDB = statusRepository.findById(id).orElseThrow();

        statusFromDB.setName(status.getName());
        statusFromDB.setDisplayname(status.getDisplayname());

        statusRepository.save(statusFromDB);
    }
    public void deleteStatus(Status status){
        statusRepository.delete(status);
    }

}
