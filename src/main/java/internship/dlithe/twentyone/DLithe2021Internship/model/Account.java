package internship.dlithe.twentyone.DLithe2021Internship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "holder")
public class Account 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="number")
	private Long accNum;
	private String accHolder, pan, address, email, accountType, password;
	private Long contact;
	private Double balance;
	
	// object to console
	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", accHolder=" + accHolder + ", pan=" + pan + ", address=" + address
				+ ", email=" + email + ", accountType=" + accountType + ", password=" + password + ", contact="
				+ contact + ", balance=" + balance + "]";
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(Long accNum, String accHolder, String pan, String address, String email, String accountType,
			String password, Long contact, Double balance) {
		super();
		this.accNum = accNum;
		this.accHolder = accHolder;
		this.pan = pan;
		this.address = address;
		this.email = email;
		this.accountType = accountType;
		this.password = password;
		this.contact = contact;
		this.balance = balance;
	}
	public Long getAccNum() {
		return accNum;
	}
	public void setAccNum(Long accNum) {
		this.accNum = accNum;
	}
	public String getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
