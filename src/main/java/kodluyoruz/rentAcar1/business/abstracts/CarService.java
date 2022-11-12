package kodluyoruz.rentAcar1.business.abstracts;

import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveCarRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateCarRequest;
import kodluyoruz.rentAcar1.business.responses.CarResponseDto;
import kodluyoruz.rentAcar1.exceptions.RentException;

import java.util.List;

public interface CarService {

    List<CarResponseDto> getAll();

    Integer add(SaveCarRequestDto saveCarRequestDto);

    boolean delete(Integer carId);

    void update(UpdateCarRequest updateCarRequest, Integer carId) throws RentException;


}
