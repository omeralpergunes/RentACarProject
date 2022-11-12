package kodluyoruz.rentAcar1.business.requests.saveRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveInvoiceIndividualRequestDto {

    private int id;
    private String email;
    private String nationalityId;
    private String firstName;
    private String lastName;
    private LocalDate invoiceTime;
    private int rentalId;
    private double totalPrice;
}
