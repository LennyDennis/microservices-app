package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name cannot be a null or empty")
    @Size(min =  5 , max =  30, message = "The legth of the customer name shoule be between 5 and 30")
    private String name;

    @NotEmpty(message = "Email cannot be a null or empty")
    @Email(message = "Email should be a valid value")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
