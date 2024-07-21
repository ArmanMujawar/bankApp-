package com.project.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bank.Entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
// operation are performed here
	
	
	
}
