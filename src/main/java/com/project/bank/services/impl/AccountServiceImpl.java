package com.project.bank.services.impl;

import com.project.bank.DataTransfer.AccountDto;
import com.project.bank.Entity.Account;
import com.project.bank.mapper.AccountMapper;
import com.project.bank.repository.AccountRepository;
import com.project.bank.services.AccountService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

	// all method implementation are done which is came from the Accountservice
	
	
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
     
        // this is for create Account 
    }

	
    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }
  
    // used for deposit 
	@Override
	public AccountDto deposit(Long id, double amount) {
		 Account account = accountRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Account does not exist"));
		 
		 double totalBalance = account.getBalance()+ amount;
		 account.setBalance(totalBalance);
		Account savedAccount= accountRepository.save(account);
		return AccountMapper.mapToAccountDto(account);
	}

	// used withdraw 
	@Override
	public AccountDto withdraw(long id, double amount) {
		Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
	 
		if(account.getBalance()<amount)
		{
			throw new RuntimeException("Insufficient balance");
		}
		
		 double totalBalance = account.getBalance()-amount;
		 account.setBalance(totalBalance);
		 Account savedAccount= accountRepository.save(account);
		 
		 return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	


	@Override 
	public List<AccountDto> getAllaccount() {
		 return accountRepository.findAll().stream()
		            .map(AccountMapper::mapToAccountDto)
		            .collect(Collectors.toList());
		}

	@Override
	public boolean deleteAccountById(Long id) {
		        if (accountRepository.existsById(id)) {
		            accountRepository.deleteById(id);
		            return true;
		        }
		return false;
	}
	

}
