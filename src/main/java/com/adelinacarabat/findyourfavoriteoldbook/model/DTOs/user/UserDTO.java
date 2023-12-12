package com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.user;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
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
    @Schema(description = "")
    @NotNull
    private String email;
    @Schema(description = "")
    private String phoneNumber;
    @Schema(description = "")
    @NotNull
    private String address;

}
