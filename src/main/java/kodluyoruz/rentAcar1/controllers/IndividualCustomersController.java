package kodluyoruz.rentAcar1.controllers;

import kodluyoruz.rentAcar1.business.abstracts.IndividualCustomerService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveIndividualCustomerRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateIndividualCustomerRequest;
import kodluyoruz.rentAcar1.business.responses.IndividualCustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/individual")
public class IndividualCustomersController {

    @Autowired
    private IndividualCustomerService individualCustomerService;


    @GetMapping("/getAll")
    public ResponseEntity<List<IndividualCustomerResponseDto>> getAll()
    {
        List<IndividualCustomerResponseDto > individualCustomerResponseDtos = individualCustomerService.getAllIndividual();
        return new ResponseEntity<>(individualCustomerResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody SaveIndividualCustomerRequestDto saveIndividualCustomerRequestDto){
        this.individualCustomerService.add(saveIndividualCustomerRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable (name = "id") int individualCustomerId){
        this.individualCustomerService.delete(individualCustomerId);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest, Integer individualId){
        this.individualCustomerService.update(updateIndividualCustomerRequest, individualId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
