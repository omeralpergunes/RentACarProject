package kodluyoruz.rentAcar1.business.requests.updateRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateIndividualCustomerRequest {

    private String isim;
    private String soyad;


}
