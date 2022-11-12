package kodluyoruz.rentAcar1.repository;

import kodluyoruz.rentAcar1.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
