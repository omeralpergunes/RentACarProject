package kodluyoruz.rentAcar1.business.requests.saveRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveInvoiceCorporateRequestDto {

    private int id;
    private String email;
    private String corporationName;
    private int rentalId;
    private double totalPrice;
    private String taxNumber;
    private LocalDate invoiceTime;

}
