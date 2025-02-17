package com.project.bank.DataTransfer;

import org.hibernate.boot.jaxb.mapping.marshall.LockModeTypeMarshalling;

public class AccountDto {

	
	private long id;
	private String accountHolderName;
	private double balance;
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDto(long id, String accountHolderName, double balance) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
