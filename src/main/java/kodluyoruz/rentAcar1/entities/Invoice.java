package kodluyoruz.rentAcar1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "invoices")
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "invoice_time")
    private LocalDate invoiceTime;

    @OneToOne
    @JoinColumn(name = "rental_id", unique = true)
    private RentalCar rental_car;

    @ManyToOne
    @JoinColumn(name = "individual_customer_id")
    private IndividualCustomer individualCustomer;

    @ManyToOne
    @JoinColumn(name = "corporate_customer_id")
    private CorporateCustomer corporateCustomer;

    @Column
    @Email
    private String email;

    @OneToOne()
    @JoinColumn(name = "payment_id", unique = true)
    private Payment payment;

}
