package com.neosoft.springPOC1.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.*;
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
