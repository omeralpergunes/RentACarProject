package kodluyoruz.rentAcar1.business.abstracts;

import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveCarFuelTypeRequestDto;
import kodluyoruz.rentAcar1.business.responses.CarFuelTypeResponseDto;
import java.util.List;

public interface CarFuelTypeService {

    List<CarFuelTypeResponseDto> getAll();

    Integer add(SaveCarFuelTypeRequestDto saveCarFuelTypeRequestDto);

    boolean delete(Integer fuelTypeId);
}
