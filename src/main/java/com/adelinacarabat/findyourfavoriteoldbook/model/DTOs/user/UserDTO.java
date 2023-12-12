package com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.user;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Schema(description = "User first name")
    @NotNull
    private String firstName;
    @Schema(description = "User last name")
    @NotNull
    private String lastName;
    @Schema(description = "The full name of the user.")
    @Hidden
    private String fullName;
    @Schema(description = "The birth date of the user.")
    @NotNull
    private LocalDate birthDate;
    @Schema(description = "The birthday of the uses.")
    @NotNull
    private String email;
    @Schema(description = "The email of the user")
    private String phoneNumber;
    @Schema(description = "The address of the user")
    @NotNull
    private String address;

}
