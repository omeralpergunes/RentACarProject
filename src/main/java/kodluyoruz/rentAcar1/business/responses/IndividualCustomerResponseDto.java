package kodluyoruz.rentAcar1.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualCustomerResponseDto {

    private int id;
    private String email;
    private String password;
    private String nationalityId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
