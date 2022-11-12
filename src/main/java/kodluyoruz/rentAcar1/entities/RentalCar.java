package kodluyoruz.rentAcar1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "rental_cars")
@NoArgsConstructor
@AllArgsConstructor
public class RentalCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_car_id")
    private int id;

    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "rent_kilometer")
    private int rentKilometer;

    @Column(name = "return_kilometer")
    private int returnKilometer;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToMany(mappedBy = "rentalCar")
    private List<Payment> payments;

    @OneToOne
    @JoinColumn(name = "invoice", unique = true)
    private Invoice invoice;


}
