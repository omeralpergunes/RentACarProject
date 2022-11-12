package kodluyoruz.rentAcar1.business.concretes;
import kodluyoruz.rentAcar1.business.abstracts.RentalCarService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveRentalCarRequestDto;
import kodluyoruz.rentAcar1.business.responses.RentalCarResponseDto;
import kodluyoruz.rentAcar1.entities.RentalCar;
import kodluyoruz.rentAcar1.repository.RentalCarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalCarManager implements RentalCarService {

    @Autowired
    private RentalCarRepository rentalCarRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RentalCarResponseDto> getAll() {
        List<RentalCar> rentalCars  = rentalCarRepository.findAll();

        List<RentalCarResponseDto> rentalCarResponseDtos = new ArrayList<RentalCarResponseDto>();

        for (RentalCar rentalCar : rentalCars) {
            RentalCarResponseDto rentalCarResponseDto = modelMapper.map(rentalCar, RentalCarResponseDto.class);
            rentalCarResponseDtos.add(rentalCarResponseDto);
        }
        return rentalCarResponseDtos;

    }

    @Override
    public Integer add(SaveRentalCarRequestDto saveRentalCarRequestDto) {
        RentalCar rentalCar  = modelMapper.map(saveRentalCarRequestDto, RentalCar.class);
        rentalCar = rentalCarRepository.save(rentalCar);
        return rentalCar.getId();
    }

    @Override
    public boolean delete(Integer rentalCarId) {
        rentalCarRepository.deleteById(rentalCarId);
        return !rentalCarRepository.existsById(rentalCarId);
    }
}
