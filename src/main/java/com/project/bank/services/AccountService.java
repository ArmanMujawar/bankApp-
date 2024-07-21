package com.project.bank.services;




import java.util.List;

import com.project.bank.DataTransfer.AccountDto;
import com.project.bank.Entity.Account;


public interface AccountService {

	//All the method creation are done her 
	
	AccountDto createAccount(AccountDto accountDto);  // method for create Account
	
	AccountDto getAccountById(Long id);  // method for find account by id
	
	AccountDto deposit(Long id , double amount );
	
	AccountDto withdraw(long id , double amount);	
	
	List<AccountDto> getAllaccount();
	
	boolean deleteAccountById(Long id);
}
