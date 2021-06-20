package br.com.leoneoliveira.SpringBootStudy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 4757362267205214671L;

    private Date timestamp;
    private String message;
    private String details;

}
