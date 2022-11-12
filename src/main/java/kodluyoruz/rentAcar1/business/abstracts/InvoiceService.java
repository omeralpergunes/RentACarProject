package kodluyoruz.rentAcar1.business.abstracts;

import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveInvoiceCorporateRequestDto;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveInvoiceIndividualRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateInvoicesRequest;
import kodluyoruz.rentAcar1.business.responses.InvoiceResponseDto;
import kodluyoruz.rentAcar1.exceptions.RentException;

import java.util.List;

public interface InvoiceService {

    List<InvoiceResponseDto> getAllInvoices();

    Integer addIndividual(SaveInvoiceIndividualRequestDto saveInvoiceIndividualRequestDto);

    Integer addCorporate(SaveInvoiceCorporateRequestDto saveInvoiceCorporateRequestDto);

    boolean delete(Integer invoiceId);

    void update(UpdateInvoicesRequest updateInvoicesRequest, Integer invoiceId) throws RentException;




}
