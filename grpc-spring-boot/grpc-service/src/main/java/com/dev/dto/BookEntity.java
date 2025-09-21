package com.dev.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class BookEntity {
    @Id
    private Integer bookId;
    private String title;
    private Float price;
    private Integer pages;
    private Integer authorId;
}
