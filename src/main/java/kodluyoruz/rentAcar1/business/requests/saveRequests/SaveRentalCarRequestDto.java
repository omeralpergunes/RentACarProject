package kodluyoruz.rentAcar1.business.requests.saveRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveRentalCarRequestDto {

    private int id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int rentKilometer;
    private int returnKilometer;
    private int customerId;
    private int carId;
    private int brandId;
    private int invoiceId;
}
