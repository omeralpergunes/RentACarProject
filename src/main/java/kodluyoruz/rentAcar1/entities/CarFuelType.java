package kodluyoruz.rentAcar1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "CarFuelTypes")
@NoArgsConstructor
@AllArgsConstructor
public class CarFuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "fuelType")
    private List<Car> cars;

}
