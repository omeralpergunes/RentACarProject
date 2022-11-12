package kodluyoruz.rentAcar1.business.requests.saveRequests;

import kodluyoruz.rentAcar1.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCarRequestDto {

    private int modelYear;

    private String description;

    private double dailyPrice;

    private int brandId;

    private String colorName;

    private int fuelTypeId;



}
