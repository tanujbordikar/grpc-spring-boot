package com.dev.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.dto.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthorId(Integer authorId);
}