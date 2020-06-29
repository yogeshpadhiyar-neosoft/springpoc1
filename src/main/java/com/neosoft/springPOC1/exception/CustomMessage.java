package com.neosoft.springPOC1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomMessage extends RuntimeException {
    private HttpStatus httpStatus;
    private String errorMessage;
    private List<String> errors;

    public CustomMessage(HttpStatus httpStatus ,  String errorMessage){
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

}
