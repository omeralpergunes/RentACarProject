package kodluyoruz.rentAcar1.controllers;

import kodluyoruz.rentAcar1.business.abstracts.CustomerService;
import kodluyoruz.rentAcar1.business.responses.CustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerResponseDto>> getAll()
    {
        List<CustomerResponseDto> customerResponseDtos = customerService.getAllCustomers();
        return new ResponseEntity<>(customerResponseDtos, HttpStatus.OK);
    }

}
