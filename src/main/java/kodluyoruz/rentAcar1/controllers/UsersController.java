package kodluyoruz.rentAcar1.controllers;

import kodluyoruz.rentAcar1.business.abstracts.UserService;
import kodluyoruz.rentAcar1.business.responses.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponseDto>> getAll()
    {
        List<UserResponseDto> userResponseDtos = userService.getAll();
        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }

}
