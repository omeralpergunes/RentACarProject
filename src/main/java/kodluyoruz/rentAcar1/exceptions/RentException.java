package kodluyoruz.rentAcar1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RentException extends RuntimeException{

    public RentException(String message) {
        super(message);
    }
}
