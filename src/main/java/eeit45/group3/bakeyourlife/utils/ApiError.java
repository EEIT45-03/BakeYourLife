package eeit45.group3.bakeyourlife.utils;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ApiError {

    private HttpStatus status;
//    private String message;
    private Map<String ,String> errors;

    public ApiError(HttpStatus status, Map<String ,String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}