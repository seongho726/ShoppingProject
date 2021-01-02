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
@AllArgsConstructor
@Builder
@ToString

@Entity(name="shoppinguser")
public class User {

	@Id
	@Column(name = "shoppinguser_id")
	int userId;

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


	
}