package kodluyoruz.rentAcar1.business.abstracts;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveCorporateCustomerRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateCorporateCustomerRequest;
import kodluyoruz.rentAcar1.business.responses.CorporateCustomerResponseDto;
import kodluyoruz.rentAcar1.exceptions.RentException;

import java.util.List;

public interface CorporateCustomerService {

    List<CorporateCustomerResponseDto> getAllCorporate();

    Integer add(SaveCorporateCustomerRequestDto saveCorporateCustomerRequestDto);

    boolean delete(Integer corporateCustomerId);

    void update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest, Integer corporateId) throws RentException;

}
