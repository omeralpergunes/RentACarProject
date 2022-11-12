package kodluyoruz.rentAcar1.business.requests.updateRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCorporateCustomerRequest {

    private String companyName;
    private String vergiNo;
}
