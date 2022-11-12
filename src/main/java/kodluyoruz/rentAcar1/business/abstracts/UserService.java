package kodluyoruz.rentAcar1.business.abstracts;

import kodluyoruz.rentAcar1.business.responses.UserResponseDto;
import java.util.List;

public interface UserService {

    List<UserResponseDto> getAll();
}
