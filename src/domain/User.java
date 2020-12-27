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
import java.sql.Date;
public class User {
    int userid;
    String usertype;
    String username;
    String password;
    Date birthdate;
    String gender;
    String email;
    String contact;
    String address;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(int userid, String usertype, String username, String password, Date birthdate, String gender,
			String email, String contact, String address) {
		super();
		this.userid = userid;
		this.usertype = usertype;
		this.username = username;
		this.password = password;
		this.birthdate = birthdate;
		this.gender = gender;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}
}