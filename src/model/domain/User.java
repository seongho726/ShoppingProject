package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity(name="shoppinguser")
public class User {

	@Id
	@Column(name = "shoppinguser_id")
	String userId;

	@Column(name = "usertype")
	String userType;

	@Column(name = "username")
	String userName;

	@Column(name = "password", nullable = false)
	String password;

	@Column(name = "email")
	String email;

	@Column(name = "contact")
	String contact;

	@Column(name = "address")
	String address;

	public User(String userId, String userName, String password, String email, String contact,
			String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}

	
	

	
}