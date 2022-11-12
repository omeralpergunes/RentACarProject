package kodluyoruz.rentAcar1.business.requests.updateRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {

    private String aciklama;
    private String renkAdi;
}
