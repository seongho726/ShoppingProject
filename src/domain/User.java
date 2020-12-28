﻿package domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class User {
	
	@Id
	@Column(name="shoppinguser_id")
    int userId;
	
	@Column(name="usertype")
    String userType;
	
	@Column(name="username")
    String userName;
	
	@Column(name="password")
    String password;
	
	@Column(name="email")
    String email;
	
	@Column(name="contact")
    String contact;
	
	@Column(name="address")
    String address;
	
	@OneToMany(mappedBy = "userId")
	private List<Basket> baskets;

	public User(int userId, String userType, String userName, String password, String email, String contact,
			String address) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}
	
}