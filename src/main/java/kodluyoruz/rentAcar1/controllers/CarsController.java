package kodluyoruz.rentAcar1.controllers;

import kodluyoruz.rentAcar1.business.abstracts.CarService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveCarRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateCarRequest;
import kodluyoruz.rentAcar1.business.responses.CarResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController{

    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        super();
        this.carService = carService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CarResponseDto>> getAll()
    {
        List<CarResponseDto > carResponseDtos = carService.getAll();
        return new ResponseEntity<>(carResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody SaveCarRequestDto saveCarRequestDto){
        this.carService.add(saveCarRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable (name = "id") int carId){
        this.carService.delete(carId);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> update(UpdateCarRequest updateCarRequest, Integer carId){
        this.carService.update(updateCarRequest, carId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

