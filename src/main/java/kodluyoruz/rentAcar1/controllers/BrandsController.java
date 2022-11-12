package kodluyoruz.rentAcar1.controllers;

import kodluyoruz.rentAcar1.business.abstracts.BrandService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveBrandRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateBrandRequest;
import kodluyoruz.rentAcar1.business.responses.BrandResponseDto;
import kodluyoruz.rentAcar1.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandsController {

    @Autowired
    private final BrandService brandService;

    @Autowired
    private final BrandRepository brandRepository;


    @GetMapping("/getAll")
    public ResponseEntity<List<BrandResponseDto>> getAll() {
        List<BrandResponseDto> brandResponseDtos = brandService.getAll();
        return new ResponseEntity<>(brandResponseDtos, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody SaveBrandRequestDto saveBrandRequestDto){
        this.brandService.add(saveBrandRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@RequestParam (name = "id") int brandId){
        this.brandService.delete(brandId);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> update(UpdateBrandRequest updateBrandRequest, Integer brandId){
        this.brandService.update(updateBrandRequest, brandId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
