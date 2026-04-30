package com.turkcell.library_cqrs_app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.turkcell.library_cqrs_app.domain.entity.Book;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}