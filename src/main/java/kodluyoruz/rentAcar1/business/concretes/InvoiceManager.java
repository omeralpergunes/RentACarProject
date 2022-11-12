package kodluyoruz.rentAcar1.business.concretes;

import kodluyoruz.rentAcar1.business.abstracts.InvoiceService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveInvoiceCorporateRequestDto;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveInvoiceIndividualRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateInvoicesRequest;
import kodluyoruz.rentAcar1.business.responses.InvoiceResponseDto;
import kodluyoruz.rentAcar1.entities.Invoice;
import kodluyoruz.rentAcar1.exceptions.RentException;
import kodluyoruz.rentAcar1.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceManager implements InvoiceService {


    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private IndividualInvoiceRepository individualInvoiceRepository;

    @Autowired
    private CorporateInvoiceRepository corporateInvoiceRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<InvoiceResponseDto> getAllInvoices() {
        List<Invoice> invoices  = invoiceRepository.findAll();

        List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<InvoiceResponseDto>();

        for (Invoice invoice : invoices) {
            InvoiceResponseDto invoiceResponseDto = modelMapper.map(invoice, InvoiceResponseDto.class);
            invoiceResponseDtos.add(invoiceResponseDto);
        }
        return invoiceResponseDtos;
    }

    @Override
    public Integer addIndividual(SaveInvoiceIndividualRequestDto saveInvoiceIndividualRequestDto) {
        Invoice individualInvoiceCustomer  = modelMapper.map(saveInvoiceIndividualRequestDto, Invoice.class);
        individualInvoiceCustomer = individualInvoiceRepository.save(individualInvoiceCustomer);
        return individualInvoiceCustomer.getId();
    }

    @Override
    public Integer addCorporate(SaveInvoiceCorporateRequestDto saveInvoiceCorporateRequestDto) {
        Invoice corporateInvoice  = modelMapper.map(saveInvoiceCorporateRequestDto, Invoice.class);
        corporateInvoice = corporateInvoiceRepository.save(corporateInvoice);
        return corporateInvoice.getId();
    }

    @Override
    public boolean delete(Integer invoiceId) {
        invoiceRepository.deleteById(invoiceId);
        return !invoiceRepository.existsById(invoiceId);
    }

    @Override
    public void update(UpdateInvoicesRequest updateInvoicesRequest, Integer invoiceId) throws RentException {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        invoice.setEmail(updateInvoicesRequest.getEposta());
        invoiceRepository.save(invoice);
    }
}
