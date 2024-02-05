package com.spring.template.silver.app.entrypoint.exceptionhandler;

import com.spring.template.silver.app.usecase.exception.error.ErrorDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
  private static final String FOUND_AN_ERROR = "Found an error: {}";

  @ExceptionHandler(NoResourceFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorDetail handleException(NoResourceFoundException ex) {
    log.error(FOUND_AN_ERROR, ex.getMessage(), ex);
    return ErrorDetail.builder().errorMessage(ex.getMessage()).build();
  }

  @ExceptionHandler(AccessDeniedException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ErrorDetail handleException(AccessDeniedException ex) {
    log.error(FOUND_AN_ERROR, ex.getMessage(), ex);
    return ErrorDetail.builder().errorMessage(ex.getMessage()).build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDetail handleException(Exception ex) {
    log.error(FOUND_AN_ERROR, ex.getMessage(), ex);
    return ErrorDetail.builder().errorMessage(ex.getMessage()).build();
  }


}
