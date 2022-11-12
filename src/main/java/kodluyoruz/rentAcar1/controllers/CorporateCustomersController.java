package kodluyoruz.rentAcar1.controllers;

import kodluyoruz.rentAcar1.business.abstracts.CorporateCustomerService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveCorporateCustomerRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateCorporateCustomerRequest;
import kodluyoruz.rentAcar1.business.responses.CorporateCustomerResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporate")
public class CorporateCustomersController {

    private CorporateCustomerService corporateCustomerService;

    public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
        this.corporateCustomerService = corporateCustomerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CorporateCustomerResponseDto>> getAll()
    {
        List<CorporateCustomerResponseDto > corporateCustomerResponseDtos = corporateCustomerService.getAllCorporate();
        return new ResponseEntity<>(corporateCustomerResponseDtos, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody SaveCorporateCustomerRequestDto saveCorporateCustomerRequestDto){
        this.corporateCustomerService.add(saveCorporateCustomerRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable (name = "id") int corporateCustomerId){
        this.corporateCustomerService.delete(corporateCustomerId);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest, Integer corporateId){
        this.corporateCustomerService.update(updateCorporateCustomerRequest, corporateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
