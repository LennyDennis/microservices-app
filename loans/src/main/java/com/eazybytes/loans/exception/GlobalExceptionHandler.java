package com.eazybytes.loans.exception;

import com.eazybytes.loans.dto.ErrorResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMsg);
        });
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(getErrorResponseDTO(ex, HttpStatus.INTERNAL_SERVER_ERROR, request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {LoanExistException.class})
    public ResponseEntity<Object> handleLoanExistException(LoanExistException ex, WebRequest request) {
        return new ResponseEntity<>(getErrorResponseDTO(ex, HttpStatus.BAD_REQUEST, request), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
        return new ResponseEntity<>(getErrorResponseDTO(resourceNotFoundException, HttpStatus.NOT_FOUND, webRequest), HttpStatus.NOT_FOUND);
    }

    private ErrorResponseDTO getErrorResponseDTO(Exception exception, HttpStatus httpStatus, WebRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                request.getDescription(false),
                httpStatus,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return errorResponseDTO;
    }


}
