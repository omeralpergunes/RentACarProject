package kodluyoruz.rentAcar1.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private int id;
    private String email;
    private String password;
}
