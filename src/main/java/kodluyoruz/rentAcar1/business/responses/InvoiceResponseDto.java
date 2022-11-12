package kodluyoruz.rentAcar1.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponseDto {

    private int id;
    private String email;
    private LocalDate invoiceTime;
    private int rentalId;
    private double totalPrice;
}
