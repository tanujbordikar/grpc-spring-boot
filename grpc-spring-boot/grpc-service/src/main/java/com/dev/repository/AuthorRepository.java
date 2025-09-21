package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.dto.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
