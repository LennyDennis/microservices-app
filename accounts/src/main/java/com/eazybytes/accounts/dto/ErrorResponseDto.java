package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Hold error response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "Api path invoked by client"
    )
    private String apiPath;

    @Schema(
            description = "Error code thrown", example = "500"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message thrown"
    )
    private String errorMessage;

    @Schema(
            description = "Time when the error happened"
    )
    private LocalDateTime errorTime;

}
