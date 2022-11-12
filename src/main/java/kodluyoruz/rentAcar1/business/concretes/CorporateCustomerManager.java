package kodluyoruz.rentAcar1.business.concretes;

import kodluyoruz.rentAcar1.business.abstracts.CorporateCustomerService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveCorporateCustomerRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateCorporateCustomerRequest;
import kodluyoruz.rentAcar1.business.responses.CorporateCustomerResponseDto;
import kodluyoruz.rentAcar1.entities.CorporateCustomer;
import kodluyoruz.rentAcar1.exceptions.RentException;
import kodluyoruz.rentAcar1.repository.CorporateCustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {

    @Autowired
    private CorporateCustomerRepository corporateCustomerRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CorporateCustomerResponseDto> getAllCorporate() {
        Iterable<CorporateCustomer> corporateCustomers = corporateCustomerRepository.findAll();

        List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = new ArrayList<CorporateCustomerResponseDto>();

        for (CorporateCustomer corporateCustomer : corporateCustomers) {
            CorporateCustomerResponseDto corporateCustomerResponseDto = modelMapper.map(corporateCustomer, CorporateCustomerResponseDto.class);
            corporateCustomerResponseDtos.add(corporateCustomerResponseDto);
        }
        return corporateCustomerResponseDtos;
    }


    @Override
    public Integer add(SaveCorporateCustomerRequestDto saveCorporateCustomerRequestDto) {
        CorporateCustomer corporateCustomer = modelMapper.map(saveCorporateCustomerRequestDto, CorporateCustomer.class);
        corporateCustomer=corporateCustomerRepository.save(corporateCustomer);
        return corporateCustomer.getId();
    }


    @Override
    public boolean delete(Integer corporateCustomerId) {
        corporateCustomerRepository.deleteById(corporateCustomerId);
        return !corporateCustomerRepository.existsById(corporateCustomerId);
    }

    @Override
    public void update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest, Integer corporateId) throws RentException {
        CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(corporateId).get();
        corporateCustomer.setCorporationName(updateCorporateCustomerRequest.getCompanyName());
        corporateCustomer.setTaxNumber(updateCorporateCustomerRequest.getVergiNo());
        corporateCustomerRepository.save(corporateCustomer);
    }
}
