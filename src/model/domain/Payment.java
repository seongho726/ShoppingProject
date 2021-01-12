package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity(name="shoppingpayment")
public class Payment {
	@Id 
	@Column (name = "payment_id")
    int paymentId;
	
	@Column (name ="paymentuser_id" )
	String userId;
	
	@Column (name = "total_count")
	int totalCount;
	
	@Column (name = "total_price")
	int totalPrice;
	
	@Column (name = "address")
	String address;
	
	@Column (name = "contact")
	String contact;
	
	@Column (name = "cc_number")
	String ccNumber;
	
	@Column (name = "cc_expiration")
	String ccExpiration;
	
	@Column (name = "cc_password")
	String ccPassword;

	public Payment(String userId, String address, String contact, String ccNumber, 
			String ccExpiration, String ccPassword) {
		super();
		this.userId = userId;
		this.address = address;
		this.contact = contact;
		this.ccNumber = ccNumber;
		this.ccExpiration = ccExpiration;
		this.ccPassword = ccPassword;
	}
}
