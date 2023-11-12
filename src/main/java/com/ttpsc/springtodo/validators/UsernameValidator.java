package com.ttpsc.springtodo.validators;

import com.ttpsc.springtodo.model.UserEntity;
import com.ttpsc.springtodo.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsernameValidator implements ConstraintValidator<UsernameValidation, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);

        return userOptional.isEmpty();
    }
}
