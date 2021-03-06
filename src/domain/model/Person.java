package domain.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
	private String userid;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Role role;
	private Address address;

	public Person(String userid, String email, String password, String firstName, String lastName, Role role) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		setUserid(userid);
		setEmail(email);
		setPasswordHashed(password);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
	}
	
	public Person() {
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		if(userid == null || userid.isEmpty()){
			throw new IllegalArgumentException("No userid given");
		}
		this.userid = userid;
	}

	public void setEmail(String email) {
		if(email == null || email.isEmpty()){
			throw new IllegalArgumentException("No email given");
		}
		String USERID_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(email);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isCorrectPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(password == null || password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(hashPassword(password));
	}

	public void setPassword(String password) {
		if(password == null || password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}

	public void setPasswordHashed(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(password == null || password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		this.password = hashPassword(password);
	}

	private String hashPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest crypt = MessageDigest.getInstance("SHA-512");
		crypt.reset();

		// encrypts
		crypt.update(password.getBytes("UTF-8"));

		//16 hexadecimal system the sixteen digits are "0–9" followed by "A–F".
		String hashedPassword = new BigInteger(1, crypt.digest()).toString(16);
		// System.out.println(hashedPassword.length());
		return hashedPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName == null || firstName.isEmpty()){
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName == null || lastName.isEmpty()){
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}

	public void setRole(Role role) {
		if (role == null) {
			role = Role.CUSTOMER;
		}
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setAddress(Address address) {
		if (address == null) throw new IllegalArgumentException("Invalid address");
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString(){
		return getFirstName() + " " + getLastName() + ": " + getUserid() + ", " + getEmail();
	}	
}
