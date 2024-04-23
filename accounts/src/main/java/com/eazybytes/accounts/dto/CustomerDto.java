package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account Information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer", example = "Lenny Dennis"
    )
    @NotEmpty(message = "Name cannot be a null or empty")
    @Size(min =  5 , max =  30, message = "The legth of the customer name shoule be between 5 and 30")
    private String name;

    @Schema(
            description = "Email address of the customer", example = "lenny.mach@zeraki.app"
    )
    @NotEmpty(message = "Email cannot be a null or empty")
    @Email(message = "Email should be a valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountsDto accountsDto;
}
