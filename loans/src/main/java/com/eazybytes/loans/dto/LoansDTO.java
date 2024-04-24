package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Loans",
        description = "Schema that holds Loans information"
)
public class LoansDTO {

    @Schema(
            description = "Mobile number for a user", example = "0792257222"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Loan number used for a specific loan", example = "11111"
    )
    @NotEmpty(message = "Loan number cannot be null or empty")
    private String loanNumber;

    @Schema(
            description = "Type of load a user is given", example = "YEARLY"
    )
    @NotEmpty(message = "Loan type cannot be null or empty")
    private String loanType;

    @Schema(
            description = "This is the total amount of the loan", example = "10000"
    )
    @NotEmpty(message = "Total loan cannot be null or empty")
    private Integer totalLoan;

    @Schema(
            description = "This is the amount of loan that had been paid", example = "5000"
    )
    @NotEmpty(message = "Amount paid cannot be null or empty")
    private Integer amountPaid;

    @Schema(
            description = "This is the balance of loan", example = "5000"
    )
    @NotEmpty(message = "Outstanding amount cannot be null or empty")
    private Integer outstandingAmount;

}
