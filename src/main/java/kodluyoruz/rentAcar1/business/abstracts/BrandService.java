package kodluyoruz.rentAcar1.business.abstracts;

import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveBrandRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateBrandRequest;
import kodluyoruz.rentAcar1.business.responses.BrandResponseDto;
import kodluyoruz.rentAcar1.exceptions.RentException;

import java.util.List;

public interface BrandService {

    List<BrandResponseDto> getAll();

    Integer add(SaveBrandRequestDto saveBrandRequestDto);

    boolean delete(Integer brandId);

    void update(UpdateBrandRequest updateBrandRequest, Integer brandId) throws RentException;






}
