package kodluyoruz.rentAcar1.controllers;

import kodluyoruz.rentAcar1.business.abstracts.InvoiceService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveInvoiceCorporateRequestDto;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveInvoiceIndividualRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateInvoicesRequest;
import kodluyoruz.rentAcar1.business.responses.InvoiceResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoicesController {

    private InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/getAllInvoices")
    public ResponseEntity<List<InvoiceResponseDto>> getAllInvoices() {
        List<InvoiceResponseDto> invoiceResponseDtos = invoiceService.getAllInvoices();
        return new ResponseEntity<>(invoiceResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/addIndividual")
    public ResponseEntity<Integer> addIndividual(@RequestBody SaveInvoiceIndividualRequestDto saveInvoiceIndividualRequestDto){
        this.invoiceService.addIndividual(saveInvoiceIndividualRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addCorporates")
    public ResponseEntity<Integer> addCorporate(@RequestBody SaveInvoiceCorporateRequestDto saveInvoiceCorporateRequestDto){
        this.invoiceService.addCorporate(saveInvoiceCorporateRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable (name = "id") int invoiceId){
        this.invoiceService.delete(invoiceId);
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> update(UpdateInvoicesRequest updateInvoicesRequest, Integer invoiceId){
        this.invoiceService.update(updateInvoicesRequest, invoiceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
