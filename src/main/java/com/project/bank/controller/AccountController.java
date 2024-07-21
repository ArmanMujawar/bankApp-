package com.project.bank.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.DataTransfer.AccountDto;
import com.project.bank.services.AccountService;
import org.springframework.web.bind.annotation.RequestParam;


// all api task are done here 

@RequestMapping("/api/accounts")
@RestController
public class AccountController {

    private final AccountService accountService;
    
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    // creation

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        AccountDto createdAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
    
    // for find the id 
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        
        return ResponseEntity.ok(accountDto);
    }
    
    // for deposit amount
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto>deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) 
    {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id,amount);
        
        return ResponseEntity.ok(accountDto);
    }
    
    // for amount withdraw
    
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) 
    {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id,amount);
        
        return ResponseEntity.ok(accountDto);
    }
    
 
   // list of accounts   
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accountDto = accountService.getAllaccount();
        return ResponseEntity.ok(accountDto);
    }
    
    // used for delete by id
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable Long id) {
        boolean deleted = accountService.deleteAccountById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
}
    

    
