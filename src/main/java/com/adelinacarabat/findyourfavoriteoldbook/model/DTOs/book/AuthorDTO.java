package com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.book;

import com.adelinacarabat.findyourfavoriteoldbook.model.Nationality;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class AuthorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Nationality nationality;

    public AuthorDTO(String firstName, String lastName, LocalDate birthDate, Nationality nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }
}
