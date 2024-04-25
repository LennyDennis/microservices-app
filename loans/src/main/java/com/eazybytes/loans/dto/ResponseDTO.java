package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        name = "Response",
        description = "This is the schema for the response"
)
@Data @AllArgsConstructor
public class ResponseDTO {

    @Schema(
            description = "This is the response status code", example = "200"
    )
    private String statusCode;

    @Schema(
            description = "This is the response message", example = "Request processed successfully"
    )
    private String statusMsg;


}
