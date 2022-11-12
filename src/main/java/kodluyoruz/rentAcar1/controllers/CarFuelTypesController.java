package kodluyoruz.rentAcar1.controllers;

import kodluyoruz.rentAcar1.business.abstracts.CarFuelTypeService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveCarFuelTypeRequestDto;
import kodluyoruz.rentAcar1.business.responses.CarFuelTypeResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carfueltypes")
public class CarFuelTypesController {

    private CarFuelTypeService carFuelTypeService;

    @Autowired
    public CarFuelTypesController(CarFuelTypeService carFuelTypeService) {
        super();
        this.carFuelTypeService = carFuelTypeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CarFuelTypeResponseDto>> getAll()
    {
        List<CarFuelTypeResponseDto> carFuelTypeResponseDtos = carFuelTypeService.getAll();
        return new ResponseEntity<>(carFuelTypeResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody SaveCarFuelTypeRequestDto saveCarFuelTypeRequestDto){
        this.carFuelTypeService.add(saveCarFuelTypeRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable (name = "id") int fuelTypeId){
        this.carFuelTypeService.delete(fuelTypeId);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }
}
