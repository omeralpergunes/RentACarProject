package kodluyoruz.rentAcar1.controllers;

import kodluyoruz.rentAcar1.business.abstracts.RentalCarService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveRentalCarRequestDto;
import kodluyoruz.rentAcar1.business.responses.RentalCarResponseDto;
import kodluyoruz.rentAcar1.repository.RentalCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalcars")
public class RentalCarsController {

    @Autowired
    private RentalCarService rentalCarService;

    @Autowired
    private RentalCarRepository rentalCarRepository;


    public RentalCarsController(RentalCarService rentalCarService, RentalCarRepository rentalCarRepository) {
        this.rentalCarService = rentalCarService;
        this.rentalCarRepository = rentalCarRepository;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<RentalCarResponseDto>> getAll()
    {
        List<RentalCarResponseDto > rentalCarResponseDtos = rentalCarService.getAll();
        return new ResponseEntity<>(rentalCarResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody SaveRentalCarRequestDto saveRentalCarRequestDto){
        this.rentalCarService.add(saveRentalCarRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@RequestParam (name = "id") int rentalCarId){
        this.rentalCarService.delete(rentalCarId);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }


}
