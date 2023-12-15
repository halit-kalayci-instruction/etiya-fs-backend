package com.etiya.training.core.utils.exceptions;

import com.etiya.training.core.utils.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // ExceptionHandler methodlarda fırlayan exception 1. parametreye automatic gönderilir.
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST) // response http status code
    public List<String> handleValidationException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getFieldErrors().stream().map(error -> {
            return error.getDefaultMessage();
        }).toList();
        return errors;
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBusinessException(BusinessException exception) {
        return exception.getMessage();
    }

   /* @ExceptionHandler({Exception.class})
    public String handleException(Exception exception) {
        return "Bilinmedik hata";
    }
    */
}
