package kodluyoruz.rentAcar1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Customers")
@PrimaryKeyJoinColumn(name = "customer_id", referencedColumnName = "user_id")
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {


    @Column(name = "customer_id", insertable = false, updatable = false)
    private int customerId;

    @OneToMany(mappedBy = "customer")
    private List<RentalCar> rentalCars;

}
