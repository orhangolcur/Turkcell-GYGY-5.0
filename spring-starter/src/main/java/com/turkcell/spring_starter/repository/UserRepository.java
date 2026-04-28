package com.turkcell.spring_starter.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.spring_starter.entity.User;

// JpaRepository<EntityName, Id alanı tipi>
public interface UserRepository extends JpaRepository<User, UUID>{
    // SELECT * FROM users WHERE email = ? bu metodu yazdığımızda bu komut Jpa tarafından oluşturulur
    Optional<User> findByEmail(String email);
}
