package kodluyoruz.rentAcar1.repository;

import kodluyoruz.rentAcar1.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
