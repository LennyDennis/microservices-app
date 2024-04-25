package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "Error Response",
        description = "This is the schema for the error response"
)
@Data @AllArgsConstructor
public class ErrorResponseDTO {

    @Schema(
            description = "This is the api path for the method that throw an error"
    )
    private String apiPath;

    @Schema(
            description = "This is the error response code"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "This is the error message"
    )
    private String errorMessage;

    @Schema(
            description = "This is the time when the error was thrown"
    )
    private LocalDateTime errorTime;

}
