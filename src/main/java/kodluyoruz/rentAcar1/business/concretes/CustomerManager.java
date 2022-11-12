package kodluyoruz.rentAcar1.business.concretes;

import kodluyoruz.rentAcar1.business.abstracts.CustomerService;
import kodluyoruz.rentAcar1.business.responses.CustomerResponseDto;
import kodluyoruz.rentAcar1.entities.Customer;
import kodluyoruz.rentAcar1.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManager implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers  = customerRepository.findAll();

        List<CustomerResponseDto> customerResponseDtos = new ArrayList<CustomerResponseDto>();

        for (Customer customer : customers) {
            CustomerResponseDto customerResponseDto = modelMapper.map(customer, CustomerResponseDto.class);
            customerResponseDtos.add(customerResponseDto);
        }
        return customerResponseDtos;
    }

}
