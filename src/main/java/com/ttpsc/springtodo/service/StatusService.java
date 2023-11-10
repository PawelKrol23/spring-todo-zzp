package com.ttpsc.springtodo.service;

import com.ttpsc.springtodo.model.Status;
import com.ttpsc.springtodo.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StatusService {
    private final StatusRepository statusRepository;


    public List<Status> getStatuses(Long userId){
        return statusRepository.getUsersStatuses(userId);
    }

    public Status getStatus(Long id) {
        return statusRepository.findById(id).orElseThrow();
    }
}
