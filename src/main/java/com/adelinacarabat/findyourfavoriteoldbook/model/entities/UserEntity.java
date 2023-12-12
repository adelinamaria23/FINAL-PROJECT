package com.adelinacarabat.findyourfavoriteoldbook.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String fullName;
    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String address;

}
