package com.adelinacarabat.findyourfavoriteoldbook.model.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "books")
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long book_id;
    @NotNull
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Set<AuthorEntity> authors;
    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate publishDate;
    @NotNull
    private String publishingHouse;
    @NotNull
    private boolean hasVolumes;
    private int volumes;


}