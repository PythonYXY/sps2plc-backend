package sps2plc.requirements;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RequirementNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(RequirementNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String RequirementNotFoundHandler(RequirementNotFoundException ex) {
        return ex.getMessage();
    }
}
