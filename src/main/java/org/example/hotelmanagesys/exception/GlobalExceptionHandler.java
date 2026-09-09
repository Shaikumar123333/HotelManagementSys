package org.example.hotelmanagesys.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(
        ResourceNotFoundException exception){

    Map<String, Object> error = new HashMap<>();

    error.put("timestamp", LocalDateTime.now());
    error.put("status", 404);
    error.put("error", "NotFound");

    error.put("message", exception.getMessage());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Map<String, Object>> handleRoomBooked(
            RoomAlreadyBookedException exception){
        Map<String, Object> error = new HashMap<>();

        error.put("timestamp" , LocalDateTime.now());
        error.put("status", 400);
        error.put("error", "BadRequest");
        error.put("message", exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
