package br.com.leoneoliveira.SpringBootStudy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{

    private static final long serialVersionUID = 7293176993519649343L;

    public UnsupportedMathOperationException(String exception) {
        super(exception);
    }
}
