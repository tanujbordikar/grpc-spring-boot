package com.dev.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "Book")
public class BookEntity {
    @Id
    private Integer bookId;
    private String title;
    private Float price;
    private Integer pages;
    private Integer authorId;
}
