package kodluyoruz.rentAcar1.repository;

import kodluyoruz.rentAcar1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
