package com.eazybytes.loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =  HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName, String resourceValue ) {
        super("Resource " + resourceName + " not found for field " + fieldName + " with resource value " + resourceValue);
    }

}
