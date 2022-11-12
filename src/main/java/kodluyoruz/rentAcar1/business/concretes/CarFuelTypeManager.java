package kodluyoruz.rentAcar1.business.concretes;
import kodluyoruz.rentAcar1.business.abstracts.CarFuelTypeService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveCarFuelTypeRequestDto;
import kodluyoruz.rentAcar1.business.responses.CarFuelTypeResponseDto;
import kodluyoruz.rentAcar1.entities.CarFuelType;
import kodluyoruz.rentAcar1.repository.CarFuelTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarFuelTypeManager implements CarFuelTypeService {

    @Autowired
    private CarFuelTypeRepository carFuelTypeRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CarFuelTypeResponseDto> getAll() {

        List<CarFuelType> carFuelTypes = carFuelTypeRepository.findAll();

        List<CarFuelTypeResponseDto> carFuelTypeResponseDtos = new ArrayList<CarFuelTypeResponseDto>();

        for (CarFuelType carFuelType : carFuelTypes) {
            CarFuelTypeResponseDto carFuelTypeResponseDto = modelMapper.map(carFuelType, CarFuelTypeResponseDto.class);
            carFuelTypeResponseDtos.add(carFuelTypeResponseDto);
        }
        return carFuelTypeResponseDtos;
    }

    @Override
    public Integer add(SaveCarFuelTypeRequestDto saveCarFuelTypeRequestDto) {
        CarFuelType carFuelType = modelMapper.map(saveCarFuelTypeRequestDto, CarFuelType.class);
        carFuelType = carFuelTypeRepository.save(carFuelType);
        return carFuelType.getId();
    }

    @Override
    public boolean delete(Integer fuelTypeId) {
        carFuelTypeRepository.deleteById(fuelTypeId);
        return !carFuelTypeRepository.existsById(fuelTypeId);
    }
}
