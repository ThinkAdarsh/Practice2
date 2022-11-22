package com.springdemo.Jpa.EXCEPTION;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcenotFound extends RuntimeException {
    public ResourcenotFound(String message) {
        super(message);
    }
}
