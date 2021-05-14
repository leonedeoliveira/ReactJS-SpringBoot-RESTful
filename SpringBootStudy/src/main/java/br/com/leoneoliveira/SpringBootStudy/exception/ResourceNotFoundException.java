package br.com.leoneoliveira.SpringBootStudy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 7293176993519649343L;

    public ResourceNotFoundException(String exception) {
        super(exception);
    }
}
