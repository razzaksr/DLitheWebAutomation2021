package internship.dlithe.twentyone.DLithe2021Internship.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Beneficiary 
{
	/*
	 * @Id @GeneratedValue(strategy = GenerationType.TABLE) private Integer id;
	 */
	@Id
	private Long number;
	private String name, ifsc, bank;
	@ManyToOne
	private Account account;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Beneficiary [accountNumber=" + number + ", name=" + name + ", ifsc=" + ifsc + ", bank=" + bank
				+ ", account=" + account + "]";
	}
	public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Beneficiary(Long accountNumber, String name, String ifsc, String bank) {
		super();
		this.number = accountNumber;
		this.name = name;
		this.ifsc = ifsc;
		this.bank = bank;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long accountNumber) {
		this.number = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
}
