package kodluyoruz.rentAcar1.business.abstracts;


import kodluyoruz.rentAcar1.business.responses.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

    List<CustomerResponseDto> getAllCustomers();
}
