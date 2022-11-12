package kodluyoruz.rentAcar1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "individual_customers")
@PrimaryKeyJoinColumn(name = "individual_customer_id", referencedColumnName = "customer_id")
@NoArgsConstructor
@AllArgsConstructor
public class IndividualCustomer extends Customer {

    @Column(name = "individual_customer_id", insertable = false, updatable = false)
    private int individualCustomerId;

    @Column(name = "nationality_id", unique = true)
    private String nationalityId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

}
