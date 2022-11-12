package kodluyoruz.rentAcar1.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponseDto {

    private int id;
    private int modelYear;
    private String description;
    private double dailyPrice;
    private int brandId;
    private String colorName;
    private int fuelTypeId;
}
