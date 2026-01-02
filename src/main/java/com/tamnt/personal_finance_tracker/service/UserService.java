package com.tamnt.personal_finance_tracker.service;

import com.tamnt.personal_finance_tracker.dto.UserRegistrationDto;
import com.tamnt.personal_finance_tracker.model.User;
import com.tamnt.personal_finance_tracker.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(UserRegistrationDto userRegistrationDto) {

        if (userRepository.findByUserName(userRegistrationDto.getUserName()) != null) {
            throw new IllegalStateException("Username already taken!");
        }

        if (userRepository.existsByEmail(userRegistrationDto.getEmail())) {
            throw new IllegalStateException("Email already taken!");
        }

        String encoderPassword = passwordEncoder.encode(userRegistrationDto.getPassword());

        User user = new User();
        user.setUserName(userRegistrationDto.getUserName());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(encoderPassword);

        return userRepository.save(user);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
