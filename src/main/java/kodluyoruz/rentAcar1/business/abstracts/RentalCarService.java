package kodluyoruz.rentAcar1.business.abstracts;

import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveRentalCarRequestDto;
import kodluyoruz.rentAcar1.business.responses.RentalCarResponseDto;

import java.util.List;

public interface  RentalCarService {

    List<RentalCarResponseDto> getAll();

    Integer add(SaveRentalCarRequestDto saveRentalCarRequestDto);

    boolean delete(Integer rentalCarId);

}
