package kodluyoruz.rentAcar1.business.concretes;

import kodluyoruz.rentAcar1.business.abstracts.CarService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveCarRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateCarRequest;
import kodluyoruz.rentAcar1.business.responses.CarResponseDto;
import kodluyoruz.rentAcar1.entities.Car;
import kodluyoruz.rentAcar1.exceptions.RentException;
import kodluyoruz.rentAcar1.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CarResponseDto> getAll() {
        List<Car> cars = carRepository.findAll();

        List<CarResponseDto> carResponseDtos = new ArrayList<CarResponseDto>();

        for (Car car : cars) {
            CarResponseDto carResponseDto = modelMapper.map(car, CarResponseDto.class);
            carResponseDtos.add(carResponseDto);
        }
        return carResponseDtos;
    }


    @Override
    public Integer add(SaveCarRequestDto saveCarRequestDto) {
        Car car = modelMapper.map(saveCarRequestDto, Car.class);
        car=carRepository.save(car);
        return car.getId();

        /*Car car  = modelMapper.map(saveCarRequestDto, Car.class);
        car = carRepository.save(car);
        return car.getId();*/

    }

    @Override
    public boolean delete(Integer carId) {
        carRepository.deleteById(carId);
        return !carRepository.existsById(carId);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest, Integer carId) throws RentException {
        Car car = carRepository.findById(carId).get();
        car.setDescription(updateCarRequest.getAciklama());
        car.setColorName(updateCarRequest.getRenkAdi());
        carRepository.save(car);
    }

}
