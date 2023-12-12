package com.adelinacarabat.findyourfavoriteoldbook.model.DTOs.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UpdateUserDTO {

    @Schema(description = "User first name")
    @NotNull
    private String firstName;
    @Schema(description = "User last name")
    @NotNull
    private String lastName;
    @NotNull
    private String address;
}
