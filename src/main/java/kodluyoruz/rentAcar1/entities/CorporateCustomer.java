package kodluyoruz.rentAcar1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "corporate_customers")
@PrimaryKeyJoinColumn(name = "corporate_customer_id",  referencedColumnName = "customer_id")

public class CorporateCustomer extends Customer{

    @Column(name = "corporate_customer_id", insertable = false, updatable = false)
    private int corporateCustomerId;

    @Column(name = "corporation_name")
    private String corporationName;

    @Column(name = "tax_number")
    private String taxNumber;

}
