package kodluyoruz.rentAcar1.repository;

import kodluyoruz.rentAcar1.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
