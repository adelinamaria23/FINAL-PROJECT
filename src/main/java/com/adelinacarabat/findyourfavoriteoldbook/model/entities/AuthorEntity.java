package com.adelinacarabat.findyourfavoriteoldbook.model.entities;

import com.adelinacarabat.findyourfavoriteoldbook.model.Nationality;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authors")
@Entity
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private Long author_id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private Nationality nationality;

    public AuthorEntity(@NotNull String firstName, @NotNull String lastName, @NotNull LocalDate birthDate, @NotNull Nationality nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }
}
