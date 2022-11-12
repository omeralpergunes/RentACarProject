package kodluyoruz.rentAcar1.business.abstracts;

import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveIndividualCustomerRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateIndividualCustomerRequest;
import kodluyoruz.rentAcar1.business.responses.IndividualCustomerResponseDto;
import kodluyoruz.rentAcar1.exceptions.RentException;

import java.util.List;

public interface IndividualCustomerService {

    List<IndividualCustomerResponseDto> getAllIndividual();

    Integer add(SaveIndividualCustomerRequestDto saveIndividualCustomerRequestDto);

    boolean delete(Integer individualId);

    void update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest, Integer individualId) throws RentException;

}
