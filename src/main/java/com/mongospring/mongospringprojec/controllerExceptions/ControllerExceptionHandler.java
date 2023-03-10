package com.mongospring.mongospringprojec.controllerExceptions;

import com.mongospring.mongospringprojec.services.exception.ObjectNotFoundExeption;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundExeption e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(), "Object not found", e.getMessage()
                ,request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }
}
