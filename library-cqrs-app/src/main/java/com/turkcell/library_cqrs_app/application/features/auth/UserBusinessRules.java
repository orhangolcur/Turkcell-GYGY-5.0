package com.turkcell.library_cqrs_app.application.features.auth;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs_app.domain.entity.User;
import com.turkcell.library_cqrs_app.persistence.repository.UserRepository;

@Component
public class UserBusinessRules {

    private final UserRepository userRepository;

    public UserBusinessRules(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void emailMustBeUnique(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Bu email zaten kullanılıyor: " + email);
        }
    }

    public User getUserByEmailOrThrow(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Giriş bilgileri yanlış"));
    }
}
