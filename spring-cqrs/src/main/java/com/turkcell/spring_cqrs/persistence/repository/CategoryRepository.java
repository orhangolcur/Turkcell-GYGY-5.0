package com.turkcell.spring_cqrs.persistence.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.spring_cqrs.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID>{
    Optional<Category> findByName(String name);
}
