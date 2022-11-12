package kodluyoruz.rentAcar1.business.requests.saveRequests;


import lombok.Data;



@Data
public class SaveCorporateCustomerRequestDto {

    private String corporationName;
    private String taxNumber;
    private String email;
    private String password;
}
