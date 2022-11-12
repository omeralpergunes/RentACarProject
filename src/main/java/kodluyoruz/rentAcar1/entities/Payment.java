package kodluyoruz.rentAcar1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int id;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne()
    @JoinColumn(name = "rental_car_id", updatable = false, nullable = false)
    private RentalCar rentalCar;

    @OneToOne(mappedBy = "payment")
    private Invoice invoice;



}

