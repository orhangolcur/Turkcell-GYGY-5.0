package com.turkcell.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.entity.BookCopy;

public interface BookCopyRepository extends JpaRepository<BookCopy, UUID>{

}
