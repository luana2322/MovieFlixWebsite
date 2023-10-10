package com.MovieFlix.MovieFlixWebsite.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ErrorRespone {
	private HttpStatus statusCode;
    private String errorMessage;
    private Object body;
    
    public ErrorRespone(HttpStatus statusCode,String errorMessage) {
    	this(statusCode,errorMessage,errorMessage);
    }
    
    public int getStatusCodeValue() {
    	return statusCode.value();
    }
}
