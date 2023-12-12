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
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private Nationality nationality;

}
