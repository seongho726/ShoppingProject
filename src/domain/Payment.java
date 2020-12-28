package domain;

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

@Entity
public class Payment {
	@Id 
	@Column (name = "payment_id")
    int paymentId;
	
	@ManyToOne
	@JoinColumn (name = "paymentuser_id", referencedColumnName = "shoppinguser_id", nullable=false)	
	User userId;
	
	@ManyToOne
	@JoinColumn (name = "product_id", referencedColumnName = "product_id", nullable=false)	
	Product productId;
	
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

}
