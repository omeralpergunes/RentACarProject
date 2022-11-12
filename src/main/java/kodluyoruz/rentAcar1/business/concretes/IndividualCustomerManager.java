package kodluyoruz.rentAcar1.business.concretes;

import kodluyoruz.rentAcar1.business.abstracts.IndividualCustomerService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveIndividualCustomerRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateIndividualCustomerRequest;
import kodluyoruz.rentAcar1.business.responses.IndividualCustomerResponseDto;
import kodluyoruz.rentAcar1.entities.IndividualCustomer;
import kodluyoruz.rentAcar1.exceptions.RentException;
import kodluyoruz.rentAcar1.repository.IndividualCustomerRepository;
import kodluyoruz.rentAcar1.repository.RentalCarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {

    @Autowired
    private IndividualCustomerRepository individualCustomerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RentalCarRepository rentalCarRepository;


    @Override
    public List<IndividualCustomerResponseDto> getAllIndividual() {
        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();

        List<IndividualCustomerResponseDto> individualCustomerResponseDtos = new ArrayList<IndividualCustomerResponseDto>();

        for (IndividualCustomer individualCustomer : individualCustomers) {
            IndividualCustomerResponseDto individualCustomerResponseDto = modelMapper.map(individualCustomer, IndividualCustomerResponseDto.class);
            individualCustomerResponseDtos.add(individualCustomerResponseDto);
        }
        return individualCustomerResponseDtos;
    }

    @Override
    public Integer add(SaveIndividualCustomerRequestDto saveIndividualCustomerRequestDto) {
        IndividualCustomer individualCustomer = modelMapper.map(saveIndividualCustomerRequestDto, IndividualCustomer.class);
        individualCustomer =individualCustomerRepository.save(individualCustomer);
        return individualCustomer.getId();
    }

    @Override
    public boolean delete(Integer individualId) {
        individualCustomerRepository.deleteById(individualId);
        return !individualCustomerRepository.existsById(individualId);
    }

    @Override
    public void update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest, Integer individualId) throws RentException {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(individualId).get();
        individualCustomer.setFirstName(updateIndividualCustomerRequest.getIsim());
        individualCustomer.setLastName(updateIndividualCustomerRequest.getSoyad());
        individualCustomerRepository.save(individualCustomer);
    }
}
