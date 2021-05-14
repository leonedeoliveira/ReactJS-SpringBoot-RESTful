package br.com.leoneoliveira.SpringBootStudy.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 4757362267205214671L;

    private Date timestemp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.timestemp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestemp() {
        return timestemp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
