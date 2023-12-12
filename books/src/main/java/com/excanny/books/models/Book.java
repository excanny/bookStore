package com.excanny.books.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private LocalDateTime creationDateTime;

    @PrePersist
    public void prePersist() {
        creationDateTime = LocalDateTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }
}
