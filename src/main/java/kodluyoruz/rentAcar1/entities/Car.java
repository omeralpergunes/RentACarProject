package kodluyoruz.rentAcar1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Cars")
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String modelYear;

    @Column
    private String description;

    @Column
    private double dailyPrice;

    @Column
    private String colorName;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "fuelType_id", nullable = false)
    private CarFuelType fuelType;

    @OneToMany(mappedBy = "car")
    private List<RentalCar> rentalCars;
}
