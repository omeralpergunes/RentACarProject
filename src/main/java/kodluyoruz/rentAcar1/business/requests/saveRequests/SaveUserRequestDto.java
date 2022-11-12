package kodluyoruz.rentAcar1.business.requests.saveRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserRequestDto {

    private String email;
    private String password;
}
