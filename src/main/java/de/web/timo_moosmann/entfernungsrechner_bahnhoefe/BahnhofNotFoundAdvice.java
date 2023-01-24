package de.web.timo_moosmann.entfernungsrechner_bahnhoefe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BahnhofNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(BahnhofNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String bahnhofNotFoundHandler(BahnhofNotFoundException ex) {
        return ex.getMessage();
    }
}
