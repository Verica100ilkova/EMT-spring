package mk.ukim.finki.lab2emt191069.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class CategoryNotFound extends RuntimeException{
    public CategoryNotFound(Long id) {
        super(String.format("Category with id %d was not found",id));
    }
}