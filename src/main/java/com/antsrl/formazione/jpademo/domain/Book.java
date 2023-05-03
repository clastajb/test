package com.antsrl.formazione.jpademo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@Table(name = "books_table")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "anycolumn", nullable = false, length = 16, unique = true)
    private String anything;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "publishing_date", nullable = false)
    private LocalDateTime publishingDate;

    @Enumerated(EnumType.STRING)
    private Category category;

}
