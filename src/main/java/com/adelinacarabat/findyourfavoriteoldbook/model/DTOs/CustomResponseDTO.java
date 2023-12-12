package com.adelinacarabat.findyourfavoriteoldbook.model.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponseDTO {
    private Object responseObject;
    private String responseMessage;

}
