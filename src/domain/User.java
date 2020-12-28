/*create table shoppinguser(
  UserID number constraints user_UserID_PK primary key,
  UserType varchar2(20),
  UserName varchar2(20),
  Password varchar2(20),
  BirthDate date,
  Email varchar2(30),
  Contact varchar2(20),
  Address varchar2(50));
 */
package domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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
    String Password;
	
	@Column(name="email")
    String Email;
	
	@Column(name="contact")
    String Contact;
	
	@Column(name="address")
    String Address;
}