package kodluyoruz.rentAcar1.business.concretes;

import kodluyoruz.rentAcar1.business.abstracts.UserService;
import kodluyoruz.rentAcar1.business.responses.UserResponseDto;
import kodluyoruz.rentAcar1.entities.User;
import kodluyoruz.rentAcar1.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserManager implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserResponseDto> getAll() {
        List<User> users  = userRepository.findAll();

        List<UserResponseDto> userResponseDtos = new ArrayList<UserResponseDto>();

        for (User user : users) {
            UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
            userResponseDtos.add(userResponseDto);
        }
        return userResponseDtos;
    }
    }

