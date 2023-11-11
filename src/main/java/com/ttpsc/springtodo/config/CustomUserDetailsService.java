package com.ttpsc.springtodo.config;

import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);

        if(userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User with name: " + username + " not found !");
        }

        UserEntity userEntity = userOptional.get();
        UserDetails userDetails = new User(
          userEntity.getUsername(),
          userEntity.getPassword(),
          Collections.singleton(new SimpleGrantedAuthority(userEntity.getRole()))
        );

        return userDetails;
    }
}
