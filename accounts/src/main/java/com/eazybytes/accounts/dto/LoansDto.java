package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        name = "Loans",
        description = "Schema that holds Loans information"
)
public class LoansDto {

    @Schema(
            description = "Mobile number for a user", example = "0792257222"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Loan number used for a specific loan", example = "11111"
    )
    @NotEmpty(message = "Loan number cannot be null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "LoanNumber must be 12 digits")
    private String loanNumber;

    @Schema(
            description = "Type of load a user is given", example = "YEARLY"
    )
    @NotEmpty(message = "Loan type cannot be null or empty")
    private String loanType;

    @Schema(
            description = "This is the total amount of the loan", example = "10000"
    )
    @Positive(message = "Total loan amount should be greater than zero")
    private Integer totalLoan;

    @Schema(
            description = "This is the amount of loan that had been paid", example = "5000"
    )
    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    private int amountPaid;

    @Schema(
            description = "This is the balance of loan", example = "5000"
    )
    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private int outstandingAmount;

}
